
-- User and database creation. Adjust as needed

CREATE USER playtech_admin WITH PASSWORD 'change_me' CREATEDB;
CREATE DATABASE playtech_db WITH OWNER playtech_admin;

-- DDL SQL for tables created by Hibernate