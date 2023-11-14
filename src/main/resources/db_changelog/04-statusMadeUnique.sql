-- liquibase formatted sql

-- changeset liquibase aubbiali:4
ALTER TABLE awesomepizza.status ADD CONSTRAINT unique_status_constraint UNIQUE (status);