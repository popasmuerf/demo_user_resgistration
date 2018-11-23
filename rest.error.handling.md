Handle Eerrors in a RESTful API
=====================================
Although a developer takes care of handling error,
it is important to design error 
responses....in a suitable format that allows a client who
consumes a RESTful API to unserstand the issues and
help by using the API correctly.

Error handlig is one of the most important concenrs
of RESTful API development.  In the real world,
a RESTful API is being conumed in various scenarios, 

and it is difficult to predict everything about the scenario 
in which the API is being consumed.



UserRegistrationSystem Error Handling
===========================================
Consider a scenario in the UserRegisterationSystem
application where the client tires to fetch
user information that doesn't exist in the system....

What if we want to get retrived a user by id: 50
when there is no id: 50 in our system ?

        @GetMapping("/{id}")
            public ResponseEntity<UserDTO> getUserById( @PathVariable("id")  Long id) {
                UserDTO user ;
                Optional<UserDTO> userOpt = userJpaRepository.findById(id);
                if(userOpt.isPresent()) {
                    user = userOpt.get();
                }else{
                    user = new UserDTO() ;
                }
        
                return new ResponseEntity <UserDTO>(user,HttpStatus.OK);
            }



When we make the call:


        > curl  -method GET -H....-d {id:50}
        
        
What we get back is :

    []
    

And empty set.....


so what happended here exactly ?
        
        1. The method when coalled looks in our persistence store
           for the object with the id of : 50
        
        2. It doesn't exist...so we get a null value returned from
           the method used to retrieve the object
           
        3. The method getUserById() method now returns but a null value
           along with an HTTP status of : 200 OK
           
If we are trying to retrieve a resource that doesn't exist....shouldn't 
we at least return an HTTP code of 404 ?  So at lesat the request knows
that the resource they are requesting does not exist....

                    @GetMapping("/{id}")
                    public ResponseEntity<UserDTO> getUserById( @PathVariable("id")  Long id) {
                        UserDTO user ;
                        Optional<UserDTO> userOpt = userJpaRepository.findById(id);
                        if(userOpt.isPresent()) {
                            user = userOpt.get();
                            return new ResponseEntity <UserDTO>(user,HttpStatus.OK);
                            
                        }else{
                            user = new UserDTO() ;
                            return new ResponseEntity <UserDTO>( new CustomerErrorType("User with id :" + id   + " not found", user,HttpStatus.NOT_FOUND);
                        }
                
                    }


