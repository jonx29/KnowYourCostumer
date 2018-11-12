--
-- PostgreSQL database dump
--

-- Dumped from database version 10.5
-- Dumped by pg_dump version 10.5

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: actividad_economica; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.actividad_economica (
    cod_tipo_actividad_economica integer NOT NULL,
    cod_cliente integer NOT NULL
);


ALTER TABLE public.actividad_economica OWNER TO postgres;

--
-- Name: calle; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.calle (
    cod_calle integer NOT NULL,
    cod_ciudad integer NOT NULL,
    nombre character varying(50) NOT NULL
);


ALTER TABLE public.calle OWNER TO postgres;

--
-- Name: calle_cod_calle_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.calle_cod_calle_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.calle_cod_calle_seq OWNER TO postgres;

--
-- Name: calle_cod_calle_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.calle_cod_calle_seq OWNED BY public.calle.cod_calle;


--
-- Name: cargo_politico; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cargo_politico (
    cod_tipo_cargo_politico integer NOT NULL,
    cod_cliente integer NOT NULL,
    cod_ciudad integer NOT NULL,
    fecha_inicio date NOT NULL,
    fecha_fin date NOT NULL
);


ALTER TABLE public.cargo_politico OWNER TO postgres;

--
-- Name: ciudad; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ciudad (
    cod_ciudad integer NOT NULL,
    cod_provincia integer NOT NULL,
    nombre character varying(50) NOT NULL
);


ALTER TABLE public.ciudad OWNER TO postgres;

--
-- Name: ciudad_cod_ciudad_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.ciudad_cod_ciudad_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.ciudad_cod_ciudad_seq OWNER TO postgres;

--
-- Name: ciudad_cod_ciudad_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.ciudad_cod_ciudad_seq OWNED BY public.ciudad.cod_ciudad;


--
-- Name: cliente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cliente (
    cod_cliente integer NOT NULL,
    cod_estado_civil integer,
    cod_genero integer,
    cod_tipo_personeria integer NOT NULL,
    pais_nacimiento character(2),
    nombres character varying(100) NOT NULL,
    apellidos character varying(100) NOT NULL,
    fecha_nacimiento date,
    fecha_hora_registro timestamp with time zone DEFAULT CURRENT_TIMESTAMP NOT NULL
);


ALTER TABLE public.cliente OWNER TO postgres;

--
-- Name: cliente_cod_cliente_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cliente_cod_cliente_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cliente_cod_cliente_seq OWNER TO postgres;

--
-- Name: cliente_cod_cliente_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cliente_cod_cliente_seq OWNED BY public.cliente.cod_cliente;


--
-- Name: contacto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.contacto (
    cod_cliente integer NOT NULL,
    cli_cod_cliente integer NOT NULL
);


ALTER TABLE public.contacto OWNER TO postgres;

--
-- Name: cuenta; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cuenta (
    numero_cuenta character varying(20) NOT NULL,
    cod_cliente integer NOT NULL,
    cod_tipo_cuenta integer NOT NULL,
    activa boolean NOT NULL
);


ALTER TABLE public.cuenta OWNER TO postgres;

--
-- Name: direccion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.direccion (
    cod_direccion integer NOT NULL,
    cod_calle integer NOT NULL,
    cod_calle_trans integer,
    numero numeric(4,0),
    referencia character varying(100)
);


ALTER TABLE public.direccion OWNER TO postgres;

--
-- Name: direccion_cliente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.direccion_cliente (
    cod_direccion integer NOT NULL,
    cod_cliente integer NOT NULL,
    referencia character varying(100)
);


ALTER TABLE public.direccion_cliente OWNER TO postgres;

--
-- Name: direccion_cod_direccion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.direccion_cod_direccion_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.direccion_cod_direccion_seq OWNER TO postgres;

--
-- Name: direccion_cod_direccion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.direccion_cod_direccion_seq OWNED BY public.direccion.cod_direccion;


--
-- Name: egreso_cliente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.egreso_cliente (
    cod_tipo_egreso integer NOT NULL,
    cod_cliente integer NOT NULL,
    valor numeric(9,0) NOT NULL
);


ALTER TABLE public.egreso_cliente OWNER TO postgres;

--
-- Name: estado_civil; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.estado_civil (
    cod_estado_civil integer NOT NULL,
    descripcion character varying(25) NOT NULL
);


ALTER TABLE public.estado_civil OWNER TO postgres;

--
-- Name: estado_civil_cod_estado_civil_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.estado_civil_cod_estado_civil_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.estado_civil_cod_estado_civil_seq OWNER TO postgres;

--
-- Name: estado_civil_cod_estado_civil_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.estado_civil_cod_estado_civil_seq OWNED BY public.estado_civil.cod_estado_civil;


--
-- Name: genero; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.genero (
    cod_genero integer NOT NULL,
    descripcion character varying(25) NOT NULL
);


ALTER TABLE public.genero OWNER TO postgres;

--
-- Name: genero_cod_genero_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.genero_cod_genero_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.genero_cod_genero_seq OWNER TO postgres;

--
-- Name: genero_cod_genero_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.genero_cod_genero_seq OWNED BY public.genero.cod_genero;


--
-- Name: identificacion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.identificacion (
    cod_tipo_identificacion integer NOT NULL,
    cod_cliente integer NOT NULL,
    cod_pais character(2) NOT NULL,
    numero_identificacion numeric(15,0) NOT NULL
);


ALTER TABLE public.identificacion OWNER TO postgres;

--
-- Name: ingreso_cliente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ingreso_cliente (
    cod_tipo_ingreso integer NOT NULL,
    cod_cliente integer NOT NULL,
    valor numeric(9,0) NOT NULL
);


ALTER TABLE public.ingreso_cliente OWNER TO postgres;

--
-- Name: nacionalidad; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.nacionalidad (
    cod_pais character(2) NOT NULL,
    cod_cliente integer NOT NULL
);


ALTER TABLE public.nacionalidad OWNER TO postgres;

--
-- Name: numero_telefono; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.numero_telefono (
    cod_tipo_telefono integer NOT NULL,
    cod_cliente integer NOT NULL,
    numero character varying(15) NOT NULL
);


ALTER TABLE public.numero_telefono OWNER TO postgres;

--
-- Name: pais; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pais (
    cod_pais character(2) NOT NULL,
    nombre character varying(100) NOT NULL
);


ALTER TABLE public.pais OWNER TO postgres;

--
-- Name: parentesco; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.parentesco (
    cod_cliente integer NOT NULL,
    cli_cod_cliente integer NOT NULL,
    cod_tipo_parentesco integer
);


ALTER TABLE public.parentesco OWNER TO postgres;

--
-- Name: profesion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.profesion (
    cod_profesion integer NOT NULL,
    descripcion character varying(25) NOT NULL
);


ALTER TABLE public.profesion OWNER TO postgres;

--
-- Name: profesion_cliente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.profesion_cliente (
    cod_cliente integer NOT NULL,
    cod_profesion integer NOT NULL
);


ALTER TABLE public.profesion_cliente OWNER TO postgres;

--
-- Name: profesion_cod_profesion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.profesion_cod_profesion_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.profesion_cod_profesion_seq OWNER TO postgres;

--
-- Name: profesion_cod_profesion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.profesion_cod_profesion_seq OWNED BY public.profesion.cod_profesion;


--
-- Name: provincia; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.provincia (
    cod_provincia integer NOT NULL,
    cod_pais character(2) NOT NULL,
    nombre character varying(25) NOT NULL
);


ALTER TABLE public.provincia OWNER TO postgres;

--
-- Name: provincia_cod_provincia_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.provincia_cod_provincia_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.provincia_cod_provincia_seq OWNER TO postgres;

--
-- Name: provincia_cod_provincia_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.provincia_cod_provincia_seq OWNED BY public.provincia.cod_provincia;


--
-- Name: referencia; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.referencia (
    cod_tipo_referencia integer,
    cod_cliente integer NOT NULL,
    cli_cod_cliente integer NOT NULL
);


ALTER TABLE public.referencia OWNER TO postgres;

--
-- Name: tipo_actividad_economica; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tipo_actividad_economica (
    cod_tipo_actividad_economica integer NOT NULL,
    descripcion character varying(25) NOT NULL
);


ALTER TABLE public.tipo_actividad_economica OWNER TO postgres;

--
-- Name: tipo_actividad_economica_cod_tipo_actividad_economica_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tipo_actividad_economica_cod_tipo_actividad_economica_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tipo_actividad_economica_cod_tipo_actividad_economica_seq OWNER TO postgres;

--
-- Name: tipo_actividad_economica_cod_tipo_actividad_economica_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tipo_actividad_economica_cod_tipo_actividad_economica_seq OWNED BY public.tipo_actividad_economica.cod_tipo_actividad_economica;


--
-- Name: tipo_cargo_politico; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tipo_cargo_politico (
    cod_tipo_cargo_politico integer NOT NULL,
    descripcion character varying(50) NOT NULL
);


ALTER TABLE public.tipo_cargo_politico OWNER TO postgres;

--
-- Name: tipo_cargo_politico_cod_tipo_cargo_politico_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tipo_cargo_politico_cod_tipo_cargo_politico_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tipo_cargo_politico_cod_tipo_cargo_politico_seq OWNER TO postgres;

--
-- Name: tipo_cargo_politico_cod_tipo_cargo_politico_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tipo_cargo_politico_cod_tipo_cargo_politico_seq OWNED BY public.tipo_cargo_politico.cod_tipo_cargo_politico;


--
-- Name: tipo_cuenta; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tipo_cuenta (
    cod_tipo_cuenta integer NOT NULL,
    descripcion character varying(50) NOT NULL
);


ALTER TABLE public.tipo_cuenta OWNER TO postgres;

--
-- Name: tipo_cuenta_cod_tipo_cuenta_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tipo_cuenta_cod_tipo_cuenta_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tipo_cuenta_cod_tipo_cuenta_seq OWNER TO postgres;

--
-- Name: tipo_cuenta_cod_tipo_cuenta_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tipo_cuenta_cod_tipo_cuenta_seq OWNED BY public.tipo_cuenta.cod_tipo_cuenta;


--
-- Name: tipo_egreso; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tipo_egreso (
    cod_tipo_egreso integer NOT NULL,
    descripcion character varying(100) NOT NULL
);


ALTER TABLE public.tipo_egreso OWNER TO postgres;

--
-- Name: tipo_egreso_cod_tipo_egreso_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tipo_egreso_cod_tipo_egreso_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tipo_egreso_cod_tipo_egreso_seq OWNER TO postgres;

--
-- Name: tipo_egreso_cod_tipo_egreso_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tipo_egreso_cod_tipo_egreso_seq OWNED BY public.tipo_egreso.cod_tipo_egreso;


--
-- Name: tipo_identificacion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tipo_identificacion (
    cod_tipo_identificacion integer NOT NULL,
    descripcion character varying(25) NOT NULL
);


ALTER TABLE public.tipo_identificacion OWNER TO postgres;

--
-- Name: tipo_identificacion_cod_tipo_identificacion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tipo_identificacion_cod_tipo_identificacion_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tipo_identificacion_cod_tipo_identificacion_seq OWNER TO postgres;

--
-- Name: tipo_identificacion_cod_tipo_identificacion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tipo_identificacion_cod_tipo_identificacion_seq OWNED BY public.tipo_identificacion.cod_tipo_identificacion;


--
-- Name: tipo_ingreso; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tipo_ingreso (
    cod_tipo_ingreso integer NOT NULL,
    descripcion character varying(100) NOT NULL
);


ALTER TABLE public.tipo_ingreso OWNER TO postgres;

--
-- Name: tipo_ingreso_cod_tipo_ingreso_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tipo_ingreso_cod_tipo_ingreso_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tipo_ingreso_cod_tipo_ingreso_seq OWNER TO postgres;

--
-- Name: tipo_ingreso_cod_tipo_ingreso_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tipo_ingreso_cod_tipo_ingreso_seq OWNED BY public.tipo_ingreso.cod_tipo_ingreso;


--
-- Name: tipo_parentesco; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tipo_parentesco (
    cod_tipo_parentesco integer NOT NULL,
    descripcion character varying(25) NOT NULL
);


ALTER TABLE public.tipo_parentesco OWNER TO postgres;

--
-- Name: tipo_parentesco_cod_tipo_parentesco_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tipo_parentesco_cod_tipo_parentesco_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tipo_parentesco_cod_tipo_parentesco_seq OWNER TO postgres;

--
-- Name: tipo_parentesco_cod_tipo_parentesco_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tipo_parentesco_cod_tipo_parentesco_seq OWNED BY public.tipo_parentesco.cod_tipo_parentesco;


--
-- Name: tipo_personeria; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tipo_personeria (
    cod_tipo_personeria integer NOT NULL,
    descripcion character varying(25) NOT NULL
);


ALTER TABLE public.tipo_personeria OWNER TO postgres;

--
-- Name: tipo_personeria_cod_tipo_personeria_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tipo_personeria_cod_tipo_personeria_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tipo_personeria_cod_tipo_personeria_seq OWNER TO postgres;

--
-- Name: tipo_personeria_cod_tipo_personeria_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tipo_personeria_cod_tipo_personeria_seq OWNED BY public.tipo_personeria.cod_tipo_personeria;


--
-- Name: tipo_referencia; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tipo_referencia (
    cod_tipo_referencia integer NOT NULL,
    descripcion character varying(50) NOT NULL
);


ALTER TABLE public.tipo_referencia OWNER TO postgres;

--
-- Name: tipo_referencia_cod_tipo_referencia_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tipo_referencia_cod_tipo_referencia_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tipo_referencia_cod_tipo_referencia_seq OWNER TO postgres;

--
-- Name: tipo_referencia_cod_tipo_referencia_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tipo_referencia_cod_tipo_referencia_seq OWNED BY public.tipo_referencia.cod_tipo_referencia;


--
-- Name: tipo_telefono; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tipo_telefono (
    cod_tipo_telefono integer NOT NULL,
    descripcion character varying(50) NOT NULL
);


ALTER TABLE public.tipo_telefono OWNER TO postgres;

--
-- Name: tipo_telefono_cod_tipo_telefono_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tipo_telefono_cod_tipo_telefono_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tipo_telefono_cod_tipo_telefono_seq OWNER TO postgres;

--
-- Name: tipo_telefono_cod_tipo_telefono_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tipo_telefono_cod_tipo_telefono_seq OWNED BY public.tipo_telefono.cod_tipo_telefono;


--
-- Name: usuario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuario (
    cod_usuario integer NOT NULL,
    nombre character varying(20) NOT NULL,
    clave character varying(100) NOT NULL,
    correo character varying(128) NOT NULL
);


ALTER TABLE public.usuario OWNER TO postgres;

--
-- Name: usuario_cod_usuario_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.usuario_cod_usuario_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.usuario_cod_usuario_seq OWNER TO postgres;

--
-- Name: usuario_cod_usuario_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.usuario_cod_usuario_seq OWNED BY public.usuario.cod_usuario;


--
-- Name: calle cod_calle; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.calle ALTER COLUMN cod_calle SET DEFAULT nextval('public.calle_cod_calle_seq'::regclass);


--
-- Name: ciudad cod_ciudad; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ciudad ALTER COLUMN cod_ciudad SET DEFAULT nextval('public.ciudad_cod_ciudad_seq'::regclass);


--
-- Name: cliente cod_cliente; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente ALTER COLUMN cod_cliente SET DEFAULT nextval('public.cliente_cod_cliente_seq'::regclass);


--
-- Name: direccion cod_direccion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.direccion ALTER COLUMN cod_direccion SET DEFAULT nextval('public.direccion_cod_direccion_seq'::regclass);


--
-- Name: estado_civil cod_estado_civil; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.estado_civil ALTER COLUMN cod_estado_civil SET DEFAULT nextval('public.estado_civil_cod_estado_civil_seq'::regclass);


--
-- Name: genero cod_genero; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.genero ALTER COLUMN cod_genero SET DEFAULT nextval('public.genero_cod_genero_seq'::regclass);


--
-- Name: profesion cod_profesion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.profesion ALTER COLUMN cod_profesion SET DEFAULT nextval('public.profesion_cod_profesion_seq'::regclass);


--
-- Name: provincia cod_provincia; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.provincia ALTER COLUMN cod_provincia SET DEFAULT nextval('public.provincia_cod_provincia_seq'::regclass);


--
-- Name: tipo_actividad_economica cod_tipo_actividad_economica; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_actividad_economica ALTER COLUMN cod_tipo_actividad_economica SET DEFAULT nextval('public.tipo_actividad_economica_cod_tipo_actividad_economica_seq'::regclass);


--
-- Name: tipo_cargo_politico cod_tipo_cargo_politico; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_cargo_politico ALTER COLUMN cod_tipo_cargo_politico SET DEFAULT nextval('public.tipo_cargo_politico_cod_tipo_cargo_politico_seq'::regclass);


--
-- Name: tipo_cuenta cod_tipo_cuenta; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_cuenta ALTER COLUMN cod_tipo_cuenta SET DEFAULT nextval('public.tipo_cuenta_cod_tipo_cuenta_seq'::regclass);


--
-- Name: tipo_egreso cod_tipo_egreso; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_egreso ALTER COLUMN cod_tipo_egreso SET DEFAULT nextval('public.tipo_egreso_cod_tipo_egreso_seq'::regclass);


--
-- Name: tipo_identificacion cod_tipo_identificacion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_identificacion ALTER COLUMN cod_tipo_identificacion SET DEFAULT nextval('public.tipo_identificacion_cod_tipo_identificacion_seq'::regclass);


--
-- Name: tipo_ingreso cod_tipo_ingreso; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_ingreso ALTER COLUMN cod_tipo_ingreso SET DEFAULT nextval('public.tipo_ingreso_cod_tipo_ingreso_seq'::regclass);


--
-- Name: tipo_parentesco cod_tipo_parentesco; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_parentesco ALTER COLUMN cod_tipo_parentesco SET DEFAULT nextval('public.tipo_parentesco_cod_tipo_parentesco_seq'::regclass);


--
-- Name: tipo_personeria cod_tipo_personeria; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_personeria ALTER COLUMN cod_tipo_personeria SET DEFAULT nextval('public.tipo_personeria_cod_tipo_personeria_seq'::regclass);


--
-- Name: tipo_referencia cod_tipo_referencia; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_referencia ALTER COLUMN cod_tipo_referencia SET DEFAULT nextval('public.tipo_referencia_cod_tipo_referencia_seq'::regclass);


--
-- Name: tipo_telefono cod_tipo_telefono; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_telefono ALTER COLUMN cod_tipo_telefono SET DEFAULT nextval('public.tipo_telefono_cod_tipo_telefono_seq'::regclass);


--
-- Name: usuario cod_usuario; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario ALTER COLUMN cod_usuario SET DEFAULT nextval('public.usuario_cod_usuario_seq'::regclass);


--
-- Data for Name: actividad_economica; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.actividad_economica (cod_tipo_actividad_economica, cod_cliente) FROM stdin;
\.


--
-- Data for Name: calle; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.calle (cod_calle, cod_ciudad, nombre) FROM stdin;
1	1	Av. Amazonas
\.


--
-- Data for Name: cargo_politico; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.cargo_politico (cod_tipo_cargo_politico, cod_cliente, cod_ciudad, fecha_inicio, fecha_fin) FROM stdin;
1	1	1	2000-01-01	2001-01-01
\.


--
-- Data for Name: ciudad; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.ciudad (cod_ciudad, cod_provincia, nombre) FROM stdin;
1	1	Quito
\.


--
-- Data for Name: cliente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.cliente (cod_cliente, cod_estado_civil, cod_genero, cod_tipo_personeria, pais_nacimiento, nombres, apellidos, fecha_nacimiento, fecha_hora_registro) FROM stdin;
1	1	1	1	EC	Diego Fernando	Pabón Rendón	2018-11-07	2018-11-07 00:00:00-05
\.


--
-- Data for Name: contacto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.contacto (cod_cliente, cli_cod_cliente) FROM stdin;
\.


--
-- Data for Name: cuenta; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.cuenta (numero_cuenta, cod_cliente, cod_tipo_cuenta, activa) FROM stdin;
743218470	1	1	t
\.


--
-- Data for Name: direccion; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.direccion (cod_direccion, cod_calle, cod_calle_trans, numero, referencia) FROM stdin;
1	1	\N	1	Casa blanca
\.


--
-- Data for Name: direccion_cliente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.direccion_cliente (cod_direccion, cod_cliente, referencia) FROM stdin;
1	1	Primer piso
\.


--
-- Data for Name: egreso_cliente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.egreso_cliente (cod_tipo_egreso, cod_cliente, valor) FROM stdin;
\.


--
-- Data for Name: estado_civil; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.estado_civil (cod_estado_civil, descripcion) FROM stdin;
1	Soltero
\.


--
-- Data for Name: genero; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.genero (cod_genero, descripcion) FROM stdin;
1	Masculino
\.


--
-- Data for Name: identificacion; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.identificacion (cod_tipo_identificacion, cod_cliente, cod_pais, numero_identificacion) FROM stdin;
\.


--
-- Data for Name: ingreso_cliente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.ingreso_cliente (cod_tipo_ingreso, cod_cliente, valor) FROM stdin;
\.


--
-- Data for Name: nacionalidad; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.nacionalidad (cod_pais, cod_cliente) FROM stdin;
\.


--
-- Data for Name: numero_telefono; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.numero_telefono (cod_tipo_telefono, cod_cliente, numero) FROM stdin;
1	1	2595096
\.


--
-- Data for Name: pais; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.pais (cod_pais, nombre) FROM stdin;
EC	Ecuador
\.


--
-- Data for Name: parentesco; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.parentesco (cod_cliente, cli_cod_cliente, cod_tipo_parentesco) FROM stdin;
\.


--
-- Data for Name: profesion; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.profesion (cod_profesion, descripcion) FROM stdin;
1	Estudiante
\.


--
-- Data for Name: profesion_cliente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.profesion_cliente (cod_cliente, cod_profesion) FROM stdin;
\.


--
-- Data for Name: provincia; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.provincia (cod_provincia, cod_pais, nombre) FROM stdin;
1	EC	Pichincha
\.


--
-- Data for Name: referencia; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.referencia (cod_tipo_referencia, cod_cliente, cli_cod_cliente) FROM stdin;
\.


--
-- Data for Name: tipo_actividad_economica; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tipo_actividad_economica (cod_tipo_actividad_economica, descripcion) FROM stdin;
\.


--
-- Data for Name: tipo_cargo_politico; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tipo_cargo_politico (cod_tipo_cargo_politico, descripcion) FROM stdin;
1	Alcalde
\.


--
-- Data for Name: tipo_cuenta; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tipo_cuenta (cod_tipo_cuenta, descripcion) FROM stdin;
1	Ahorros
\.


--
-- Data for Name: tipo_egreso; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tipo_egreso (cod_tipo_egreso, descripcion) FROM stdin;
1	Seguro médico
\.


--
-- Data for Name: tipo_identificacion; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tipo_identificacion (cod_tipo_identificacion, descripcion) FROM stdin;
1	Cédula de identidad
\.


--
-- Data for Name: tipo_ingreso; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tipo_ingreso (cod_tipo_ingreso, descripcion) FROM stdin;
1	Sueldo
\.


--
-- Data for Name: tipo_parentesco; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tipo_parentesco (cod_tipo_parentesco, descripcion) FROM stdin;
1	Padre
\.


--
-- Data for Name: tipo_personeria; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tipo_personeria (cod_tipo_personeria, descripcion) FROM stdin;
1	Persona natural
\.


--
-- Data for Name: tipo_referencia; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tipo_referencia (cod_tipo_referencia, descripcion) FROM stdin;
1	Comercial
\.


--
-- Data for Name: tipo_telefono; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tipo_telefono (cod_tipo_telefono, descripcion) FROM stdin;
1	Convencional
\.


--
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.usuario (cod_usuario, nombre, clave, correo) FROM stdin;
1	usuario1	clave1	usuario1@espe.edu.ec
\.


--
-- Name: calle_cod_calle_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.calle_cod_calle_seq', 1, true);


--
-- Name: ciudad_cod_ciudad_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.ciudad_cod_ciudad_seq', 1, true);


--
-- Name: cliente_cod_cliente_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cliente_cod_cliente_seq', 1, true);


--
-- Name: direccion_cod_direccion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.direccion_cod_direccion_seq', 1, true);


--
-- Name: estado_civil_cod_estado_civil_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.estado_civil_cod_estado_civil_seq', 1, true);


--
-- Name: genero_cod_genero_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.genero_cod_genero_seq', 1, true);


--
-- Name: profesion_cod_profesion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.profesion_cod_profesion_seq', 1, true);


--
-- Name: provincia_cod_provincia_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.provincia_cod_provincia_seq', 1, true);


--
-- Name: tipo_actividad_economica_cod_tipo_actividad_economica_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tipo_actividad_economica_cod_tipo_actividad_economica_seq', 1, false);


--
-- Name: tipo_cargo_politico_cod_tipo_cargo_politico_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tipo_cargo_politico_cod_tipo_cargo_politico_seq', 1, true);


--
-- Name: tipo_cuenta_cod_tipo_cuenta_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tipo_cuenta_cod_tipo_cuenta_seq', 1, true);


--
-- Name: tipo_egreso_cod_tipo_egreso_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tipo_egreso_cod_tipo_egreso_seq', 1, true);


--
-- Name: tipo_identificacion_cod_tipo_identificacion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tipo_identificacion_cod_tipo_identificacion_seq', 1, true);


--
-- Name: tipo_ingreso_cod_tipo_ingreso_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tipo_ingreso_cod_tipo_ingreso_seq', 1, true);


--
-- Name: tipo_parentesco_cod_tipo_parentesco_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tipo_parentesco_cod_tipo_parentesco_seq', 1, true);


--
-- Name: tipo_personeria_cod_tipo_personeria_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tipo_personeria_cod_tipo_personeria_seq', 1, true);


--
-- Name: tipo_referencia_cod_tipo_referencia_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tipo_referencia_cod_tipo_referencia_seq', 1, true);


--
-- Name: tipo_telefono_cod_tipo_telefono_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tipo_telefono_cod_tipo_telefono_seq', 1, true);


--
-- Name: usuario_cod_usuario_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.usuario_cod_usuario_seq', 1, true);


--
-- Name: calle ak_key_2_calle; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.calle
    ADD CONSTRAINT ak_key_2_calle UNIQUE (cod_ciudad, nombre);


--
-- Name: ciudad ak_key_2_ciudad; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ciudad
    ADD CONSTRAINT ak_key_2_ciudad UNIQUE (cod_provincia, nombre);


--
-- Name: cliente ak_key_2_cliente; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT ak_key_2_cliente UNIQUE (cod_estado_civil, cod_genero, cod_tipo_personeria, pais_nacimiento, nombres, apellidos, fecha_nacimiento);


--
-- Name: direccion ak_key_2_direccio; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.direccion
    ADD CONSTRAINT ak_key_2_direccio UNIQUE (cod_calle, cod_calle_trans, numero, referencia);


--
-- Name: estado_civil ak_key_2_estado_c; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.estado_civil
    ADD CONSTRAINT ak_key_2_estado_c UNIQUE (descripcion);


--
-- Name: genero ak_key_2_genero; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.genero
    ADD CONSTRAINT ak_key_2_genero UNIQUE (descripcion);


--
-- Name: pais ak_key_2_pais; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pais
    ADD CONSTRAINT ak_key_2_pais UNIQUE (nombre);


--
-- Name: profesion ak_key_2_profesio; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.profesion
    ADD CONSTRAINT ak_key_2_profesio UNIQUE (descripcion);


--
-- Name: provincia ak_key_2_provinci; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.provincia
    ADD CONSTRAINT ak_key_2_provinci UNIQUE (cod_pais, nombre);


--
-- Name: tipo_actividad_economica ak_key_2_tipo_act; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_actividad_economica
    ADD CONSTRAINT ak_key_2_tipo_act UNIQUE (descripcion);


--
-- Name: tipo_cargo_politico ak_key_2_tipo_car; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_cargo_politico
    ADD CONSTRAINT ak_key_2_tipo_car UNIQUE (descripcion);


--
-- Name: tipo_cuenta ak_key_2_tipo_cue; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_cuenta
    ADD CONSTRAINT ak_key_2_tipo_cue UNIQUE (descripcion);


--
-- Name: tipo_egreso ak_key_2_tipo_egr; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_egreso
    ADD CONSTRAINT ak_key_2_tipo_egr UNIQUE (descripcion);


--
-- Name: tipo_identificacion ak_key_2_tipo_ide; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_identificacion
    ADD CONSTRAINT ak_key_2_tipo_ide UNIQUE (descripcion);


--
-- Name: tipo_ingreso ak_key_2_tipo_ing; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_ingreso
    ADD CONSTRAINT ak_key_2_tipo_ing UNIQUE (descripcion);


--
-- Name: tipo_parentesco ak_key_2_tipo_par; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_parentesco
    ADD CONSTRAINT ak_key_2_tipo_par UNIQUE (descripcion);


--
-- Name: tipo_personeria ak_key_2_tipo_per; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_personeria
    ADD CONSTRAINT ak_key_2_tipo_per UNIQUE (descripcion);


--
-- Name: tipo_referencia ak_key_2_tipo_ref; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_referencia
    ADD CONSTRAINT ak_key_2_tipo_ref UNIQUE (descripcion);


--
-- Name: tipo_telefono ak_key_2_tipo_tel; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_telefono
    ADD CONSTRAINT ak_key_2_tipo_tel UNIQUE (descripcion);


--
-- Name: usuario ak_key_2_usuario; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT ak_key_2_usuario UNIQUE (correo);


--
-- Name: actividad_economica pk_actividad_economica; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.actividad_economica
    ADD CONSTRAINT pk_actividad_economica PRIMARY KEY (cod_tipo_actividad_economica, cod_cliente);


--
-- Name: calle pk_calle; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.calle
    ADD CONSTRAINT pk_calle PRIMARY KEY (cod_calle);


--
-- Name: cargo_politico pk_cargo_politico; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cargo_politico
    ADD CONSTRAINT pk_cargo_politico PRIMARY KEY (cod_tipo_cargo_politico, cod_cliente, cod_ciudad, fecha_inicio, fecha_fin);


--
-- Name: ciudad pk_ciudad; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ciudad
    ADD CONSTRAINT pk_ciudad PRIMARY KEY (cod_ciudad);


--
-- Name: cliente pk_cliente; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT pk_cliente PRIMARY KEY (cod_cliente);


--
-- Name: contacto pk_contacto; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contacto
    ADD CONSTRAINT pk_contacto PRIMARY KEY (cod_cliente, cli_cod_cliente);


--
-- Name: cuenta pk_cuenta; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cuenta
    ADD CONSTRAINT pk_cuenta PRIMARY KEY (numero_cuenta);


--
-- Name: direccion pk_direccion; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.direccion
    ADD CONSTRAINT pk_direccion PRIMARY KEY (cod_direccion);


--
-- Name: direccion_cliente pk_direccion_cliente; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.direccion_cliente
    ADD CONSTRAINT pk_direccion_cliente PRIMARY KEY (cod_direccion, cod_cliente);


--
-- Name: egreso_cliente pk_egreso_cliente; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.egreso_cliente
    ADD CONSTRAINT pk_egreso_cliente PRIMARY KEY (cod_tipo_egreso, cod_cliente);


--
-- Name: estado_civil pk_estado_civil; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.estado_civil
    ADD CONSTRAINT pk_estado_civil PRIMARY KEY (cod_estado_civil);


--
-- Name: genero pk_genero; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.genero
    ADD CONSTRAINT pk_genero PRIMARY KEY (cod_genero);


--
-- Name: identificacion pk_identificacion; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.identificacion
    ADD CONSTRAINT pk_identificacion PRIMARY KEY (cod_tipo_identificacion, cod_cliente, cod_pais);


--
-- Name: ingreso_cliente pk_ingreso_cliente; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ingreso_cliente
    ADD CONSTRAINT pk_ingreso_cliente PRIMARY KEY (cod_tipo_ingreso, cod_cliente);


--
-- Name: nacionalidad pk_nacionalidad; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.nacionalidad
    ADD CONSTRAINT pk_nacionalidad PRIMARY KEY (cod_pais, cod_cliente);


--
-- Name: numero_telefono pk_numero_telefono; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.numero_telefono
    ADD CONSTRAINT pk_numero_telefono PRIMARY KEY (cod_cliente, numero);


--
-- Name: pais pk_pais; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pais
    ADD CONSTRAINT pk_pais PRIMARY KEY (cod_pais);


--
-- Name: parentesco pk_parentesco; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.parentesco
    ADD CONSTRAINT pk_parentesco PRIMARY KEY (cod_cliente, cli_cod_cliente);


--
-- Name: profesion pk_profesion; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.profesion
    ADD CONSTRAINT pk_profesion PRIMARY KEY (cod_profesion);


--
-- Name: profesion_cliente pk_profesion_cliente; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.profesion_cliente
    ADD CONSTRAINT pk_profesion_cliente PRIMARY KEY (cod_cliente, cod_profesion);


--
-- Name: provincia pk_provincia; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.provincia
    ADD CONSTRAINT pk_provincia PRIMARY KEY (cod_provincia);


--
-- Name: referencia pk_referencia; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.referencia
    ADD CONSTRAINT pk_referencia PRIMARY KEY (cod_cliente, cli_cod_cliente);


--
-- Name: tipo_actividad_economica pk_tipo_actividad_economica; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_actividad_economica
    ADD CONSTRAINT pk_tipo_actividad_economica PRIMARY KEY (cod_tipo_actividad_economica);


--
-- Name: tipo_cargo_politico pk_tipo_cargo_politico; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_cargo_politico
    ADD CONSTRAINT pk_tipo_cargo_politico PRIMARY KEY (cod_tipo_cargo_politico);


--
-- Name: tipo_cuenta pk_tipo_cuenta; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_cuenta
    ADD CONSTRAINT pk_tipo_cuenta PRIMARY KEY (cod_tipo_cuenta);


--
-- Name: tipo_egreso pk_tipo_egreso; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_egreso
    ADD CONSTRAINT pk_tipo_egreso PRIMARY KEY (cod_tipo_egreso);


--
-- Name: tipo_identificacion pk_tipo_identificacion; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_identificacion
    ADD CONSTRAINT pk_tipo_identificacion PRIMARY KEY (cod_tipo_identificacion);


--
-- Name: tipo_ingreso pk_tipo_ingreso; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_ingreso
    ADD CONSTRAINT pk_tipo_ingreso PRIMARY KEY (cod_tipo_ingreso);


--
-- Name: tipo_parentesco pk_tipo_parentesco; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_parentesco
    ADD CONSTRAINT pk_tipo_parentesco PRIMARY KEY (cod_tipo_parentesco);


--
-- Name: tipo_personeria pk_tipo_personeria; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_personeria
    ADD CONSTRAINT pk_tipo_personeria PRIMARY KEY (cod_tipo_personeria);


--
-- Name: tipo_referencia pk_tipo_referencia; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_referencia
    ADD CONSTRAINT pk_tipo_referencia PRIMARY KEY (cod_tipo_referencia);


--
-- Name: tipo_telefono pk_tipo_telefono; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_telefono
    ADD CONSTRAINT pk_tipo_telefono PRIMARY KEY (cod_tipo_telefono);


--
-- Name: usuario pk_usuario; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT pk_usuario PRIMARY KEY (cod_usuario);


--
-- Name: actividad_economica fk_activida_reference_cliente; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.actividad_economica
    ADD CONSTRAINT fk_activida_reference_cliente FOREIGN KEY (cod_cliente) REFERENCES public.cliente(cod_cliente) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: actividad_economica fk_activida_reference_tipo_act; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.actividad_economica
    ADD CONSTRAINT fk_activida_reference_tipo_act FOREIGN KEY (cod_tipo_actividad_economica) REFERENCES public.tipo_actividad_economica(cod_tipo_actividad_economica) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: calle fk_calle_reference_ciudad; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.calle
    ADD CONSTRAINT fk_calle_reference_ciudad FOREIGN KEY (cod_ciudad) REFERENCES public.ciudad(cod_ciudad) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: cargo_politico fk_cargo_po_reference_ciudad; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cargo_politico
    ADD CONSTRAINT fk_cargo_po_reference_ciudad FOREIGN KEY (cod_ciudad) REFERENCES public.ciudad(cod_ciudad) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: cargo_politico fk_cargo_po_reference_cliente; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cargo_politico
    ADD CONSTRAINT fk_cargo_po_reference_cliente FOREIGN KEY (cod_cliente) REFERENCES public.cliente(cod_cliente) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: cargo_politico fk_cargo_po_reference_tipo_car; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cargo_politico
    ADD CONSTRAINT fk_cargo_po_reference_tipo_car FOREIGN KEY (cod_tipo_cargo_politico) REFERENCES public.tipo_cargo_politico(cod_tipo_cargo_politico) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: ciudad fk_ciudad_reference_provinci; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ciudad
    ADD CONSTRAINT fk_ciudad_reference_provinci FOREIGN KEY (cod_provincia) REFERENCES public.provincia(cod_provincia) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: cliente fk_cliente_reference_estado_c; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT fk_cliente_reference_estado_c FOREIGN KEY (cod_estado_civil) REFERENCES public.estado_civil(cod_estado_civil) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: cliente fk_cliente_reference_genero; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT fk_cliente_reference_genero FOREIGN KEY (cod_genero) REFERENCES public.genero(cod_genero) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: cliente fk_cliente_reference_pais; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT fk_cliente_reference_pais FOREIGN KEY (pais_nacimiento) REFERENCES public.pais(cod_pais) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: cliente fk_cliente_reference_tipo_per; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT fk_cliente_reference_tipo_per FOREIGN KEY (cod_tipo_personeria) REFERENCES public.tipo_personeria(cod_tipo_personeria) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: contacto fk_contacto_reference_cliente; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contacto
    ADD CONSTRAINT fk_contacto_reference_cliente FOREIGN KEY (cli_cod_cliente) REFERENCES public.cliente(cod_cliente) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: contacto fk_contacto_reference_cliente2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contacto
    ADD CONSTRAINT fk_contacto_reference_cliente2 FOREIGN KEY (cod_cliente) REFERENCES public.cliente(cod_cliente) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: cuenta fk_cuenta_reference_cliente; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cuenta
    ADD CONSTRAINT fk_cuenta_reference_cliente FOREIGN KEY (cod_cliente) REFERENCES public.cliente(cod_cliente) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: cuenta fk_cuenta_reference_tipo_cue; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cuenta
    ADD CONSTRAINT fk_cuenta_reference_tipo_cue FOREIGN KEY (cod_tipo_cuenta) REFERENCES public.tipo_cuenta(cod_tipo_cuenta) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: direccion fk_direccio_reference_calle; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.direccion
    ADD CONSTRAINT fk_direccio_reference_calle FOREIGN KEY (cod_calle_trans) REFERENCES public.calle(cod_calle) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: direccion fk_direccio_reference_calle2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.direccion
    ADD CONSTRAINT fk_direccio_reference_calle2 FOREIGN KEY (cod_calle) REFERENCES public.calle(cod_calle) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: direccion_cliente fk_direccio_reference_cliente; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.direccion_cliente
    ADD CONSTRAINT fk_direccio_reference_cliente FOREIGN KEY (cod_cliente) REFERENCES public.cliente(cod_cliente) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: direccion_cliente fk_direccio_reference_direccio; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.direccion_cliente
    ADD CONSTRAINT fk_direccio_reference_direccio FOREIGN KEY (cod_direccion) REFERENCES public.direccion(cod_direccion) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: egreso_cliente fk_egreso_c_reference_cliente; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.egreso_cliente
    ADD CONSTRAINT fk_egreso_c_reference_cliente FOREIGN KEY (cod_cliente) REFERENCES public.cliente(cod_cliente) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: egreso_cliente fk_egreso_c_reference_tipo_egr; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.egreso_cliente
    ADD CONSTRAINT fk_egreso_c_reference_tipo_egr FOREIGN KEY (cod_tipo_egreso) REFERENCES public.tipo_egreso(cod_tipo_egreso) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: identificacion fk_identifi_reference_cliente; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.identificacion
    ADD CONSTRAINT fk_identifi_reference_cliente FOREIGN KEY (cod_cliente) REFERENCES public.cliente(cod_cliente) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: identificacion fk_identifi_reference_pais; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.identificacion
    ADD CONSTRAINT fk_identifi_reference_pais FOREIGN KEY (cod_pais) REFERENCES public.pais(cod_pais) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: identificacion fk_identifi_reference_tipo_ide; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.identificacion
    ADD CONSTRAINT fk_identifi_reference_tipo_ide FOREIGN KEY (cod_tipo_identificacion) REFERENCES public.tipo_identificacion(cod_tipo_identificacion) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: ingreso_cliente fk_ingreso__reference_cliente; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ingreso_cliente
    ADD CONSTRAINT fk_ingreso__reference_cliente FOREIGN KEY (cod_cliente) REFERENCES public.cliente(cod_cliente) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: ingreso_cliente fk_ingreso__reference_tipo_ing; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ingreso_cliente
    ADD CONSTRAINT fk_ingreso__reference_tipo_ing FOREIGN KEY (cod_tipo_ingreso) REFERENCES public.tipo_ingreso(cod_tipo_ingreso) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: nacionalidad fk_nacional_reference_cliente; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.nacionalidad
    ADD CONSTRAINT fk_nacional_reference_cliente FOREIGN KEY (cod_cliente) REFERENCES public.cliente(cod_cliente) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: nacionalidad fk_nacional_reference_pais; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.nacionalidad
    ADD CONSTRAINT fk_nacional_reference_pais FOREIGN KEY (cod_pais) REFERENCES public.pais(cod_pais) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: numero_telefono fk_numero_t_reference_cliente; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.numero_telefono
    ADD CONSTRAINT fk_numero_t_reference_cliente FOREIGN KEY (cod_cliente) REFERENCES public.cliente(cod_cliente) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: numero_telefono fk_numero_t_reference_tipo_tel; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.numero_telefono
    ADD CONSTRAINT fk_numero_t_reference_tipo_tel FOREIGN KEY (cod_tipo_telefono) REFERENCES public.tipo_telefono(cod_tipo_telefono) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: parentesco fk_parentes_reference_cliente; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.parentesco
    ADD CONSTRAINT fk_parentes_reference_cliente FOREIGN KEY (cli_cod_cliente) REFERENCES public.cliente(cod_cliente) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: parentesco fk_parentes_reference_cliente2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.parentesco
    ADD CONSTRAINT fk_parentes_reference_cliente2 FOREIGN KEY (cod_cliente) REFERENCES public.cliente(cod_cliente) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: parentesco fk_parentes_reference_tipo_par; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.parentesco
    ADD CONSTRAINT fk_parentes_reference_tipo_par FOREIGN KEY (cod_tipo_parentesco) REFERENCES public.tipo_parentesco(cod_tipo_parentesco) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: profesion_cliente fk_profesio_reference_cliente; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.profesion_cliente
    ADD CONSTRAINT fk_profesio_reference_cliente FOREIGN KEY (cod_cliente) REFERENCES public.cliente(cod_cliente) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: profesion_cliente fk_profesio_reference_profesio; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.profesion_cliente
    ADD CONSTRAINT fk_profesio_reference_profesio FOREIGN KEY (cod_profesion) REFERENCES public.profesion(cod_profesion) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: provincia fk_provinci_reference_pais; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.provincia
    ADD CONSTRAINT fk_provinci_reference_pais FOREIGN KEY (cod_pais) REFERENCES public.pais(cod_pais) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: referencia fk_referenc_reference_cliente; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.referencia
    ADD CONSTRAINT fk_referenc_reference_cliente FOREIGN KEY (cli_cod_cliente) REFERENCES public.cliente(cod_cliente) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: referencia fk_referenc_reference_cliente2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.referencia
    ADD CONSTRAINT fk_referenc_reference_cliente2 FOREIGN KEY (cod_cliente) REFERENCES public.cliente(cod_cliente) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: referencia fk_referenc_reference_tipo_ref; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.referencia
    ADD CONSTRAINT fk_referenc_reference_tipo_ref FOREIGN KEY (cod_tipo_referencia) REFERENCES public.tipo_referencia(cod_tipo_referencia) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- PostgreSQL database dump complete
--

