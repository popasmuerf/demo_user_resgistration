Adding the Bean Validation Annotations
========================================
We need to annotate our Beans...in particular
our UsersDTO entity class with annotations that
will not allow for null values


for instance...if we want to to ensure to constrain
the attributes of our bean before any transactions
with our presistence layer can take place.....
we can use the Hibernate Validataor, which is a popular
JSR 303 and JSR 349 implementation framework.

    @Entity
    @Table(name="Users")
    
    public class UserDTO {
        @Id
        @GeneratedValue
        @Column(name="USER_ID")
        private Long id ;
    
        @javax.validation.constraints.NotEmpty
        @Length(max=50)
        @Column(name = "NAME")
        private String name ;
    
        @javax.validation.constraints.NotEmpty
        @Length(max=50)
        @Column(name="ADDRESS")
        private String address ;
    
        @Email
        @javax.validation.constraints.NotEmpty
        @Column(name = "EMAIL")
        private String email ;
    
        /*
        public void UserDTO(//Long id,
                            String name,
                            String address,
                            String email){
            //this.id = id ;
            this.name = name ;
            this.address = address ;
            this.email = email ;
    
        }
        */
    
        public Long getId(){return id ;}
        public void setId(Long id){this.id = id ;}
        public String getName(){return name ;}
        public void setName(String name){this.name = name ;}
        public String  getAddress(){return address ;}
        public void setAddress(String address){this.address = address;}
        public String getEmail(){return email;}
        public void setEmail(String email ){this.email = email ;}
    
    
    }
    
    
    
    
NotNull --  The annotated memeber variable must not be null

NotEmpty -- The annotated member variable (string, collection ,map,
            or array) is not null or empty
            
Size    --  The annotated member variable(string,collection,map, array)
            size must be between the specified boundaries ()
            
   
Length --   This performs an update operation


Email   --  The annotated member variable (string)
            has to be well-formed valid
            e-mail address
            
Min     --  The annotated member variable(BigDecimal, BigInteger,
            Byte, Short, int long)
            
            
Max     -- The annotated member variable(BigDecimal, BigInteger,
                       Byte, Short, int long)
                       
   
   
   
On the controller side of things...
======================================
The @RequestBody method argument can be
annotted with @Valid to invoke automatic
validation similar to the support for 
@ModelAttribute method arguments...
A resulting MethodArgumentNotValidException
is handled in teh DefaultHandlerExeption
and results in a 400 responsed code


    @PostMapping(value="/",consumes = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<UserDTO> createUser(@Valid @RequestBody final UserDTO user){
            userJpaRepository.save(user);
            return new ResponseEntity<UserDTO>(user, HttpStatus.CREATED);
        }

                       
                       
By using teh @Valid annotation, Spring delegates the validation
to a registered validator....
On running the UserRegistrationSystem application
and sending a REST request with a missing address...or what have you....
you will get bak a 400 Bad Request...