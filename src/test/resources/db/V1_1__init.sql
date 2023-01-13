DROP TABLE IF EXISTS "contact_email" CASCADE;
DROP TABLE IF EXISTS "contact_phone" CASCADE;
DROP TABLE IF EXISTS "contact_phone" CASCADE;
DROP TABLE IF EXISTS "contact" CASCADE;
DROP TABLE IF EXISTS "company_region" CASCADE;
DROP TABLE IF EXISTS "company_type" CASCADE;
DROP TABLE IF EXISTS "rf_user" CASCADE;
DROP TABLE IF EXISTS "sales_team" CASCADE;
create sequence IF NOT EXISTS hibernate_sequence start with 7 increment by 1;

CREATE TABLE company (
    id bigint NOT NULL,
    name varchar(255),
    priv_team varchar(255),
    tenantid varchar(255),
    companytype_id bigint,
    salesteam_id bigint
);

CREATE TABLE company_region (
    id bigint NOT NULL,
    name varchar(255),
    tenantid varchar(255)
);

CREATE TABLE company_type (
    id bigint NOT NULL,
    name varchar(255),
    tenantid varchar(255)
);


CREATE TABLE contact (
    id bigint NOT NULL,
    assistant_name varchar(255),
    context varchar(255),
    create_date date,
    dept varchar(255),
    first_name varchar(255),
    full_name varchar(255),
    image_p_ath varchar(255),
    is_active boolean,
    is_bounce boolean,
    is_delete boolean,
    is_global_contact boolean,
    is_primary boolean,
    is_sync boolean,
    job_title varchar(255),
    last_name varchar(255),
    location varchar(255),
    manager_name varchar(255),
    middle_name varchar(255),
    notes varchar(255),
    ref_no varchar(255),
    referred_by varchar(255),
    suffix varchar(255),
    tenantid varchar(255),
    title varchar(255),
    update_date date,
    company_id bigint NOT NULL,
    createruser_id bigint NOT NULL,
    parentcompany_id bigint,
    region_id bigint,
    salesteam_id bigint,
    updateuser_id bigint,
    user_id bigint
);


CREATE TABLE contact_address (
    id bigint NOT NULL,
    address varchar(255),
    address_type integer NOT NULL,
    city varchar(255),
    country varchar(255),
    formatted_address varchar(255),
    po_box varchar(255),
    state varchar(255),
    zip_code varchar(255),
    contact_id bigint NOT NULL
);


CREATE TABLE contact_email (
    id bigint NOT NULL,
    email varchar(255) NOT NULL,
    email_type integer NOT NULL,
    contact_id bigint NOT NULL
);


CREATE TABLE contact_phone (
    id bigint NOT NULL,
    phone varchar(255) NOT NULL,
    phone_type bigint NOT NULL,
    contact_id bigint NOT NULL
);

CREATE TABLE rf_user (
    id bigint NOT NULL,
    name varchar(255),
    tenantid varchar(255)
);


CREATE TABLE sales_team (
    id bigint NOT NULL,
    name varchar(255),
    tenantid varchar(255)
);

INSERT INTO company_region (id, name, tenantid) values (1,'Region 1',0);
INSERT INTO company_region (id, name, tenantid) values (2,'Region 2',0);
INSERT INTO company_region (id, name, tenantid) values (3,'Region 3',0);
INSERT INTO company_region (id, name, tenantid) values (4,'Region 4',1);
INSERT INTO company_region (id, name, tenantid) values (5,'Region 5',1);
INSERT INTO company_region (id, name, tenantid) values (6,'Region 6',1);

INSERT INTO company (id, name, priv_team, tenantid, companytype_id, salesteam_id) values 
(1,'Company 1', 'priv_team 1',0,1,1),
(2,'Company 2', 'priv_team 2',0,2,2),
(3,'Company 3', 'priv_team 3',0,3,3),
(4,'Company 4', 'priv_team 5',1,4,4),
(5,'Company 5', 'priv_team 6',1,5,5),
(6,'Company 6', 'priv_team 7',1,6,6);

INSERT INTO company_type (id, name, tenantid) VALUES
(1,'Type 1',0),
(2,'Type 2',0),
(3,'Type 3',0),
(4,'Type 4',1),
(5,'Type 5',1),
(6,'Type 6',1);

INSERT INTO contact (id, assistant_name, context, create_date, dept, first_name, full_name, image_p_ath, is_active, is_bounce, is_delete, is_global_contact, is_primary, is_sync, job_title, last_name, location, manager_name, middle_name, notes, ref_no, referred_by, suffix, tenantid, title, update_date, company_id, createruser_id, parentcompany_id, region_id, salesteam_id, updateuser_id, user_id) VALUES
(1,'Assistant 1','Context 1','2022-12-18','Departament 1','First Name 1', 'Full name 1', 'Image 1', 1,0,0,0,1,0,'Job 1','Last Name 1','location 1','Manager 1','Middle Name 1', 'Notes 1', 'Ref 1', 'Ref By 1', 'Suf 1', 0, 'Title 1', '2022-12-18', 1, 1, 1, 1, 1, 1, 1),
(2,'Assistant 2','Context 2','2022-12-19','Departament 2','First Name 2', 'Full name 2', 'Image 2', 1,0,0,0,1,0,'Job 2','Last Name 2','location 2','Manager 2','Middle Name 2', 'Notes 2', 'Ref 2', 'Ref By 2', 'Suf 2', 0, 'Title 2', '2022-12-19', 2, 2, 2, 2, 2, 2, 2),
(3,'Assistant 3','Context 3','2022-12-20','Departament 3','First Name 3', 'Full name 3', 'Image 3', 1,0,0,0,1,0,'Job 3','Last Name 3','location 3','Manager 3','Middle Name 3', 'Notes 3', 'Ref 3', 'Ref By 3', 'Suf 3', 0, 'Title 3', '2022-12-20', 3, 3, 3, 3, 3, 3, 3),
(4,'Assistant 4','Context 4','2022-12-21','Departament 4','First Name 4', 'Full name 4', 'Image 4', 1,0,0,0,1,0,'Job 4','Last Name 4','location 4','Manager 4','Middle Name 4', 'Notes 4', 'Ref 4', 'Ref By 4', 'Suf 4', 1, 'Title 4', '2022-12-21', 4, 4, 4, 4, 4, 4, 4),
(5,'Assistant 5','Context 5','2022-12-22','Departament 5','First Name 5', 'Full name 5', 'Image 5', 1,0,0,0,1,0,'Job 5','Last Name 5','location 5','Manager 5','Middle Name 5', 'Notes 5', 'Ref 5', 'Ref By 5', 'Suf 5', 1, 'Title 5', '2022-12-22', 5, 5, 5, 5, 5, 5, 5),
(6,'Assistant 6','Context 6','2022-12-23','Departament 6','First Name 6', 'Full name 6', 'Image 6', 1,0,0,0,1,0,'Job 6','Last Name 6','location 6','Manager 6','Middle Name 6', 'Notes 6', 'Ref 6', 'Ref By 6', 'Suf 6', 1, 'Title 6', '2022-12-23', 6, 6, 6, 6, 6, 6, 6);

INSERT INTO contact_address (id, address, address_type, city, country, formatted_address, po_box, state, zip_code, contact_id) VALUES
(1, 'Address 1', 0,'City 1', 'Country 1', 'Formatted 1', 'PO BOX 1', 'State 1', 1, 1),
(2, 'Address 2', 1,'City 2', 'Country 2', 'Formatted 2', 'PO BOX 2', 'State 2', 2, 2),
(3, 'Address 3', 0,'City 3', 'Country 3', 'Formatted 3', 'PO BOX 3', 'State 3', 3, 3),
(4, 'Address 4', 1,'City 4', 'Country 4', 'Formatted 4', 'PO BOX 4', 'State 4', 4, 4),
(5, 'Address 5', 0,'City 5', 'Country 5', 'Formatted 5', 'PO BOX 5', 'State 5', 5, 5),
(6, 'Address 6', 1,'City 6', 'Country 6', 'Formatted 6', 'PO BOX 6', 'State 6', 6, 6);

INSERT INTO contact_email (id, email, email_type, contact_id) VALUES
(1,'email1@server.com',0,1),
(2,'email2@server.com',1,2),
(3,'email3@server.com',0,3),
(4,'email4@server.com',1,4),
(5,'email5@server.com',0,5),
(6,'email6@server.com',1,6);

INSERT INTO contact_phone (id, phone, phone_type, contact_id) VALUES
(1,'Phone 1',0,1),
(2,'Phone 1',1,1),
(3,'Phone 1',2,1),
(4,'Phone 1',3,1),
(5,'Phone 1',4,1),
(6,'Phone 1',0,1);

INSERT INTO rf_user (id, name, tenantid) VALUES
(1,'RF USER 1',0),
(2,'RF USER 2',0),
(3,'RF USER 3',0),
(4,'RF USER 4',1),
(5,'RF USER 5',1),
(6,'RF USER 6',1);

INSERT INTO sales_team (id, name, tenantid) VALUES
(1,'Sales Team 1', 0),
(2,'Sales Team 2', 0),
(3,'Sales Team 3', 0),
(4,'Sales Team 4', 1),
(5,'Sales Team 5', 1),
(6,'Sales Team 6', 1);

ALTER TABLE company ADD CONSTRAINT company_pkey PRIMARY KEY (id);
ALTER TABLE company_region ADD CONSTRAINT company_region_pkey PRIMARY KEY (id);
ALTER TABLE company_type ADD CONSTRAINT company_type_pkey PRIMARY KEY (id);
ALTER TABLE contact_address ADD CONSTRAINT contact_address_pkey PRIMARY KEY (id);
ALTER TABLE contact_email ADD CONSTRAINT contact_email_pkey PRIMARY KEY (id);
ALTER TABLE contact_phone ADD CONSTRAINT contact_phone_pkey PRIMARY KEY (id);
ALTER TABLE contact ADD CONSTRAINT contact_pkey PRIMARY KEY (id);
ALTER TABLE rf_user ADD CONSTRAINT rf_user_pkey PRIMARY KEY (id);
ALTER TABLE sales_team ADD CONSTRAINT sales_team_pkey PRIMARY KEY (id);
ALTER TABLE company ADD CONSTRAINT fk8k3x5nxpih0insn04o9w8qq7q FOREIGN KEY (salesteam_id) REFERENCES sales_team(id);
ALTER TABLE contact ADD CONSTRAINT fk8lqm2v1nyj6nemeqdm60k72hh FOREIGN KEY (region_id) REFERENCES company_region(id);
ALTER TABLE contact ADD CONSTRAINT fka5ir1mfkokqn2dhwv4diwy8st FOREIGN KEY (parentcompany_id) REFERENCES company(id);
ALTER TABLE contact ADD CONSTRAINT fkg22o4e2mimjiemaf884vg0kp3 FOREIGN KEY (user_id) REFERENCES rf_user(id);
ALTER TABLE contact ADD CONSTRAINT fkif0jyc75dpk695jg8i7uqumuq FOREIGN KEY (salesteam_id) REFERENCES sales_team(id);
ALTER TABLE company ADD CONSTRAINT fkjfdgyudysmhrqjcwouskh9swe FOREIGN KEY (companytype_id) REFERENCES company_type(id);
ALTER TABLE contact_email ADD CONSTRAINT fkjhb6oolv2p95xsci34vuoiq00 FOREIGN KEY (contact_id) REFERENCES contact(id);
ALTER TABLE contact_phone ADD CONSTRAINT fkjlssyu3cvwtmtimsa8vx9nh5 FOREIGN KEY (contact_id) REFERENCES contact(id);
ALTER TABLE contact ADD CONSTRAINT fkkbkyniy98pbidomhjbws8wee2 FOREIGN KEY (updateuser_id) REFERENCES rf_user(id);
ALTER TABLE contact ADD CONSTRAINT fkpgbqt6dnai52x55o1qvsx1dfn FOREIGN KEY (company_id) REFERENCES company(id);
ALTER TABLE contact_address ADD CONSTRAINT fkqqxykpjj1qrgxle7cpp0txicc FOREIGN KEY (contact_id) REFERENCES contact(id);
ALTER TABLE contact ADD CONSTRAINT fkqyy5cuhhym1vcjhlohmv1ma2b FOREIGN KEY (createruser_id) REFERENCES rf_user(id);

