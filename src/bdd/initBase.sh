#! /bin/sh -e

psql universityRequest < build.sql  
psql universityRequest < insertData.sql  
