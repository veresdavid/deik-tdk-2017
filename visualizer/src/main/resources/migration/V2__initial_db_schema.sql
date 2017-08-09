-- users table
CREATE TABLE public.users
(
    id bigint NOT NULL DEFAULT nextval('hibernate_sequence'),
    username character varying COLLATE pg_catalog."default",
    email character varying COLLATE pg_catalog."default",
    password character varying COLLATE pg_catalog."default",
    CONSTRAINT user_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

-- processes table
CREATE TABLE public.processes
(
    id bigint NOT NULL DEFAULT nextval('hibernate_sequence'),
    process_identifier character varying COLLATE pg_catalog."default",
    done boolean DEFAULT false,
    error boolean DEFAULT false,
    error_message character varying COLLATE pg_catalog."default",
    state_space_file_name character varying COLLATE pg_catalog."default",
    solution_file_name character varying COLLATE pg_catalog."default",
    java_package_name character varying COLLATE pg_catalog."default",
    name character varying COLLATE pg_catalog."default",
    creation_date date,
    user_id bigint,
    CONSTRAINT process_pkey PRIMARY KEY (id),
    CONSTRAINT user_id_to_process FOREIGN KEY (user_id)
        REFERENCES public.users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

CREATE INDEX fki_user_id
    ON public.processes USING btree
    (user_id)
    TABLESPACE pg_default;
