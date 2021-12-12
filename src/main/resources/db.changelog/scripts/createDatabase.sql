--liquibase formatted sql

--changeset tpontes-database
create database mensageria;
--rollback drop table momento;