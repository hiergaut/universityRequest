#! /bin/sh -e

ip=$1
user=$2
baseName=$3
password=$4

if [ $# -ne 4 ]
then
    echo "usage : ./initBase ip user baseName password"
    exit 1
fi
# psql universityRequest < build.sql  
# psql universityRequest < insertData.sql  
PGPASSWORD=$password psql -h $ip -U $user $baseName -f ./src/bdd/build.sql
PGPASSWORD=$password psql -h $ip -U $user $baseName -f ./src/bdd/insertData.sql

