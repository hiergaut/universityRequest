
only with postgres SGBD !


create universityRequest dataBase
    $ createdb universityRequest

build table 
    $ psql universityRequest < build.sql  

insert data
    $ psql universityRequest < insertData.sql  
