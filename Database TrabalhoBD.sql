PGDMP     
        	            y            bd_trabalho    13.2    13.3 7    ?           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ?           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            ?           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ?           1262    24576    bd_trabalho    DATABASE     k   CREATE DATABASE bd_trabalho WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Portuguese_Brazil.1252';
    DROP DATABASE bd_trabalho;
                postgres    false                        3079    24577 	   adminpack 	   EXTENSION     A   CREATE EXTENSION IF NOT EXISTS adminpack WITH SCHEMA pg_catalog;
    DROP EXTENSION adminpack;
                   false            ?           0    0    EXTENSION adminpack    COMMENT     M   COMMENT ON EXTENSION adminpack IS 'administrative functions for PostgreSQL';
                        false    2            ?            1259    49276    cad_funcionario    TABLE     .  CREATE TABLE public.cad_funcionario (
    id_fun integer NOT NULL,
    nome_fun character varying(200) NOT NULL,
    doc_fun character varying(20) NOT NULL,
    user_name_fun character varying(50) NOT NULL,
    senha_fun character varying(20) NOT NULL,
    email_fun character varying(200) NOT NULL
);
 #   DROP TABLE public.cad_funcionario;
       public         heap    postgres    false            ?            1259    49274    cad_funcionario_id_fun_seq    SEQUENCE     ?   CREATE SEQUENCE public.cad_funcionario_id_fun_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE public.cad_funcionario_id_fun_seq;
       public          postgres    false    213            ?           0    0    cad_funcionario_id_fun_seq    SEQUENCE OWNED BY     Y   ALTER SEQUENCE public.cad_funcionario_id_fun_seq OWNED BY public.cad_funcionario.id_fun;
          public          postgres    false    212            ?            1259    49215    contato_paciente    TABLE     ?   CREATE TABLE public.contato_paciente (
    id_contato integer NOT NULL,
    id_paciente integer NOT NULL,
    fone_paciente character varying(200),
    celular_paciente character varying(50),
    email_paciente character varying(200)
);
 $   DROP TABLE public.contato_paciente;
       public         heap    postgres    false            ?            1259    49218    contato_paciente_id_contato_seq    SEQUENCE     ?   CREATE SEQUENCE public.contato_paciente_id_contato_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 6   DROP SEQUENCE public.contato_paciente_id_contato_seq;
       public          postgres    false    201            ?           0    0    contato_paciente_id_contato_seq    SEQUENCE OWNED BY     c   ALTER SEQUENCE public.contato_paciente_id_contato_seq OWNED BY public.contato_paciente.id_contato;
          public          postgres    false    202            ?            1259    49220     contato_paciente_id_paciente_seq    SEQUENCE     ?   CREATE SEQUENCE public.contato_paciente_id_paciente_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 7   DROP SEQUENCE public.contato_paciente_id_paciente_seq;
       public          postgres    false    201            ?           0    0     contato_paciente_id_paciente_seq    SEQUENCE OWNED BY     e   ALTER SEQUENCE public.contato_paciente_id_paciente_seq OWNED BY public.contato_paciente.id_paciente;
          public          postgres    false    203            ?            1259    49222    dados_paciente    TABLE     G  CREATE TABLE public.dados_paciente (
    id_paciente integer NOT NULL,
    nome_paciente character varying(100),
    data_nasc_paciente date,
    rg_paciente character varying(100),
    org_emissor_paciente character varying(50),
    cpf_paciente character varying(100) NOT NULL,
    num_sus_paciente character varying(100)
);
 "   DROP TABLE public.dados_paciente;
       public         heap    postgres    false            ?            1259    49225    dados_paciente_id_paciente_seq    SEQUENCE     ?   CREATE SEQUENCE public.dados_paciente_id_paciente_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 5   DROP SEQUENCE public.dados_paciente_id_paciente_seq;
       public          postgres    false    204            ?           0    0    dados_paciente_id_paciente_seq    SEQUENCE OWNED BY     a   ALTER SEQUENCE public.dados_paciente_id_paciente_seq OWNED BY public.dados_paciente.id_paciente;
          public          postgres    false    205            ?            1259    49227    endereco_paciente    TABLE     ?  CREATE TABLE public.endereco_paciente (
    id_endereco integer NOT NULL,
    id_paciente integer NOT NULL,
    rua_paciente character varying(200),
    num_paciente character varying(50),
    bairro_paciente character varying(200),
    cidade_paciente character varying(200),
    uf_paciente character varying(5),
    complemento_paciente character varying(200),
    cep_paciente character varying(15)
);
 %   DROP TABLE public.endereco_paciente;
       public         heap    postgres    false            ?            1259    49233 !   endereco_paciente_id_endereco_seq    SEQUENCE     ?   CREATE SEQUENCE public.endereco_paciente_id_endereco_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 8   DROP SEQUENCE public.endereco_paciente_id_endereco_seq;
       public          postgres    false    206            ?           0    0 !   endereco_paciente_id_endereco_seq    SEQUENCE OWNED BY     g   ALTER SEQUENCE public.endereco_paciente_id_endereco_seq OWNED BY public.endereco_paciente.id_endereco;
          public          postgres    false    207            ?            1259    49235 !   endereco_paciente_id_paciente_seq    SEQUENCE     ?   CREATE SEQUENCE public.endereco_paciente_id_paciente_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 8   DROP SEQUENCE public.endereco_paciente_id_paciente_seq;
       public          postgres    false    206            ?           0    0 !   endereco_paciente_id_paciente_seq    SEQUENCE OWNED BY     g   ALTER SEQUENCE public.endereco_paciente_id_paciente_seq OWNED BY public.endereco_paciente.id_paciente;
          public          postgres    false    208            ?            1259    49237    vacina_paciente    TABLE     ?   CREATE TABLE public.vacina_paciente (
    id_vacina integer NOT NULL,
    id_paciente integer NOT NULL,
    tipo_vac_paciente character varying(200),
    data1_vac_paciente date,
    data2_vac_paciente date
);
 #   DROP TABLE public.vacina_paciente;
       public         heap    postgres    false            ?            1259    49240    vacina_paciente_id_paciente_seq    SEQUENCE     ?   CREATE SEQUENCE public.vacina_paciente_id_paciente_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 6   DROP SEQUENCE public.vacina_paciente_id_paciente_seq;
       public          postgres    false    209            ?           0    0    vacina_paciente_id_paciente_seq    SEQUENCE OWNED BY     c   ALTER SEQUENCE public.vacina_paciente_id_paciente_seq OWNED BY public.vacina_paciente.id_paciente;
          public          postgres    false    210            ?            1259    49242    vacina_paciente_id_vacina_seq    SEQUENCE     ?   CREATE SEQUENCE public.vacina_paciente_id_vacina_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 4   DROP SEQUENCE public.vacina_paciente_id_vacina_seq;
       public          postgres    false    209            ?           0    0    vacina_paciente_id_vacina_seq    SEQUENCE OWNED BY     _   ALTER SEQUENCE public.vacina_paciente_id_vacina_seq OWNED BY public.vacina_paciente.id_vacina;
          public          postgres    false    211            I           2604    49279    cad_funcionario id_fun    DEFAULT     ?   ALTER TABLE ONLY public.cad_funcionario ALTER COLUMN id_fun SET DEFAULT nextval('public.cad_funcionario_id_fun_seq'::regclass);
 E   ALTER TABLE public.cad_funcionario ALTER COLUMN id_fun DROP DEFAULT;
       public          postgres    false    212    213    213            B           2604    49244    contato_paciente id_contato    DEFAULT     ?   ALTER TABLE ONLY public.contato_paciente ALTER COLUMN id_contato SET DEFAULT nextval('public.contato_paciente_id_contato_seq'::regclass);
 J   ALTER TABLE public.contato_paciente ALTER COLUMN id_contato DROP DEFAULT;
       public          postgres    false    202    201            C           2604    49245    contato_paciente id_paciente    DEFAULT     ?   ALTER TABLE ONLY public.contato_paciente ALTER COLUMN id_paciente SET DEFAULT nextval('public.contato_paciente_id_paciente_seq'::regclass);
 K   ALTER TABLE public.contato_paciente ALTER COLUMN id_paciente DROP DEFAULT;
       public          postgres    false    203    201            D           2604    49246    dados_paciente id_paciente    DEFAULT     ?   ALTER TABLE ONLY public.dados_paciente ALTER COLUMN id_paciente SET DEFAULT nextval('public.dados_paciente_id_paciente_seq'::regclass);
 I   ALTER TABLE public.dados_paciente ALTER COLUMN id_paciente DROP DEFAULT;
       public          postgres    false    205    204            E           2604    49247    endereco_paciente id_endereco    DEFAULT     ?   ALTER TABLE ONLY public.endereco_paciente ALTER COLUMN id_endereco SET DEFAULT nextval('public.endereco_paciente_id_endereco_seq'::regclass);
 L   ALTER TABLE public.endereco_paciente ALTER COLUMN id_endereco DROP DEFAULT;
       public          postgres    false    207    206            F           2604    49248    endereco_paciente id_paciente    DEFAULT     ?   ALTER TABLE ONLY public.endereco_paciente ALTER COLUMN id_paciente SET DEFAULT nextval('public.endereco_paciente_id_paciente_seq'::regclass);
 L   ALTER TABLE public.endereco_paciente ALTER COLUMN id_paciente DROP DEFAULT;
       public          postgres    false    208    206            G           2604    49249    vacina_paciente id_vacina    DEFAULT     ?   ALTER TABLE ONLY public.vacina_paciente ALTER COLUMN id_vacina SET DEFAULT nextval('public.vacina_paciente_id_vacina_seq'::regclass);
 H   ALTER TABLE public.vacina_paciente ALTER COLUMN id_vacina DROP DEFAULT;
       public          postgres    false    211    209            H           2604    49250    vacina_paciente id_paciente    DEFAULT     ?   ALTER TABLE ONLY public.vacina_paciente ALTER COLUMN id_paciente SET DEFAULT nextval('public.vacina_paciente_id_paciente_seq'::regclass);
 J   ALTER TABLE public.vacina_paciente ALTER COLUMN id_paciente DROP DEFAULT;
       public          postgres    false    210    209            ?          0    49276    cad_funcionario 
   TABLE DATA           i   COPY public.cad_funcionario (id_fun, nome_fun, doc_fun, user_name_fun, senha_fun, email_fun) FROM stdin;
    public          postgres    false    213   F       ?          0    49215    contato_paciente 
   TABLE DATA           t   COPY public.contato_paciente (id_contato, id_paciente, fone_paciente, celular_paciente, email_paciente) FROM stdin;
    public          postgres    false    201   6F       ?          0    49222    dados_paciente 
   TABLE DATA           ?   COPY public.dados_paciente (id_paciente, nome_paciente, data_nasc_paciente, rg_paciente, org_emissor_paciente, cpf_paciente, num_sus_paciente) FROM stdin;
    public          postgres    false    204   SF       ?          0    49227    endereco_paciente 
   TABLE DATA           ?   COPY public.endereco_paciente (id_endereco, id_paciente, rua_paciente, num_paciente, bairro_paciente, cidade_paciente, uf_paciente, complemento_paciente, cep_paciente) FROM stdin;
    public          postgres    false    206   pF       ?          0    49237    vacina_paciente 
   TABLE DATA           |   COPY public.vacina_paciente (id_vacina, id_paciente, tipo_vac_paciente, data1_vac_paciente, data2_vac_paciente) FROM stdin;
    public          postgres    false    209   ?F       ?           0    0    cad_funcionario_id_fun_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public.cad_funcionario_id_fun_seq', 1, false);
          public          postgres    false    212            ?           0    0    contato_paciente_id_contato_seq    SEQUENCE SET     N   SELECT pg_catalog.setval('public.contato_paciente_id_contato_seq', 1, false);
          public          postgres    false    202            ?           0    0     contato_paciente_id_paciente_seq    SEQUENCE SET     O   SELECT pg_catalog.setval('public.contato_paciente_id_paciente_seq', 1, false);
          public          postgres    false    203            ?           0    0    dados_paciente_id_paciente_seq    SEQUENCE SET     M   SELECT pg_catalog.setval('public.dados_paciente_id_paciente_seq', 1, false);
          public          postgres    false    205            ?           0    0 !   endereco_paciente_id_endereco_seq    SEQUENCE SET     P   SELECT pg_catalog.setval('public.endereco_paciente_id_endereco_seq', 1, false);
          public          postgres    false    207            ?           0    0 !   endereco_paciente_id_paciente_seq    SEQUENCE SET     P   SELECT pg_catalog.setval('public.endereco_paciente_id_paciente_seq', 1, false);
          public          postgres    false    208            ?           0    0    vacina_paciente_id_paciente_seq    SEQUENCE SET     N   SELECT pg_catalog.setval('public.vacina_paciente_id_paciente_seq', 1, false);
          public          postgres    false    210            ?           0    0    vacina_paciente_id_vacina_seq    SEQUENCE SET     L   SELECT pg_catalog.setval('public.vacina_paciente_id_vacina_seq', 1, false);
          public          postgres    false    211            K           2606    49252 &   contato_paciente contato_paciente_pkey 
   CONSTRAINT     l   ALTER TABLE ONLY public.contato_paciente
    ADD CONSTRAINT contato_paciente_pkey PRIMARY KEY (id_contato);
 P   ALTER TABLE ONLY public.contato_paciente DROP CONSTRAINT contato_paciente_pkey;
       public            postgres    false    201            M           2606    49254 "   dados_paciente dados_paciente_pkey 
   CONSTRAINT     i   ALTER TABLE ONLY public.dados_paciente
    ADD CONSTRAINT dados_paciente_pkey PRIMARY KEY (id_paciente);
 L   ALTER TABLE ONLY public.dados_paciente DROP CONSTRAINT dados_paciente_pkey;
       public            postgres    false    204            O           2606    49256 (   endereco_paciente endereco_paciente_pkey 
   CONSTRAINT     o   ALTER TABLE ONLY public.endereco_paciente
    ADD CONSTRAINT endereco_paciente_pkey PRIMARY KEY (id_endereco);
 R   ALTER TABLE ONLY public.endereco_paciente DROP CONSTRAINT endereco_paciente_pkey;
       public            postgres    false    206            Q           2606    49258 $   vacina_paciente vacina_paciente_pkey 
   CONSTRAINT     i   ALTER TABLE ONLY public.vacina_paciente
    ADD CONSTRAINT vacina_paciente_pkey PRIMARY KEY (id_vacina);
 N   ALTER TABLE ONLY public.vacina_paciente DROP CONSTRAINT vacina_paciente_pkey;
       public            postgres    false    209            R           2606    49259 2   contato_paciente contato_paciente_id_paciente_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.contato_paciente
    ADD CONSTRAINT contato_paciente_id_paciente_fkey FOREIGN KEY (id_paciente) REFERENCES public.dados_paciente(id_paciente) ON UPDATE CASCADE ON DELETE CASCADE;
 \   ALTER TABLE ONLY public.contato_paciente DROP CONSTRAINT contato_paciente_id_paciente_fkey;
       public          postgres    false    201    204    2893            S           2606    49264 4   endereco_paciente endereco_paciente_id_paciente_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.endereco_paciente
    ADD CONSTRAINT endereco_paciente_id_paciente_fkey FOREIGN KEY (id_paciente) REFERENCES public.dados_paciente(id_paciente) ON UPDATE CASCADE ON DELETE CASCADE;
 ^   ALTER TABLE ONLY public.endereco_paciente DROP CONSTRAINT endereco_paciente_id_paciente_fkey;
       public          postgres    false    206    2893    204            T           2606    49269 0   vacina_paciente vacina_paciente_id_paciente_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.vacina_paciente
    ADD CONSTRAINT vacina_paciente_id_paciente_fkey FOREIGN KEY (id_paciente) REFERENCES public.dados_paciente(id_paciente) ON UPDATE CASCADE ON DELETE CASCADE;
 Z   ALTER TABLE ONLY public.vacina_paciente DROP CONSTRAINT vacina_paciente_id_paciente_fkey;
       public          postgres    false    209    204    2893            ?      x?????? ? ?      ?      x?????? ? ?      ?      x?????? ? ?      ?      x?????? ? ?      ?      x?????? ? ?     