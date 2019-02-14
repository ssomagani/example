#! /bin/bash

mvn clean compile assembly:single

sqlcmd < ddl.sql

sqlcmd --query='exec SayHello hindi'
