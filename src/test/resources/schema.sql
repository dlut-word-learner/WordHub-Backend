-- auto-generated definition
create table if not exists language
(
    lang_id   int auto_increment
        primary key,
    lang_name varchar(15) not null,
    constraint language_pk
        unique (lang_name)
);

create table if not exists dict
(
    dict_id   int auto_increment
        primary key,
    lang_id   int         not null,
    dict_name varchar(20) not null,
    constraint dict_language_lang_id_fk
        foreign key (lang_id) references language (lang_id)
);

create table if not exists word
(
    word_id   int auto_increment
        primary key,
    word_name varchar(20) not null,
    dict_id   int         not null,
    constraint word_dict_dict_id_fk
        foreign key (dict_id) references dict (dict_id)
);

-- auto-generated definition
create table if not exists "user"
(
    user_id          int primary key auto_increment,
    user_name        varchar(30)       not null,
    user_password    char(60)          not null,
    user_email       varchar(50)       not null,
    user_avatar_path varchar(255)      null,
    user_score       int     default 0 not null,
    user_role        tinyint default 0 not null,
    constraint user_pk_email
        unique (user_email),
    constraint user_pk_name
        unique (user_name)
);

create table if not exists card
(
    card_id      int primary key auto_increment,
    word_id      int                  not null,
    card_content varchar(200)         not null,
    is_public    tinyint(1) default 0 not null,
    user_id      int                  not null,
    constraint card_user_user_id_fk
        foreign key (user_id) references "user" (user_id),
    constraint card_word_word_id_fk
        foreign key (word_id) references word (word_id)
);

-- auto-generated definition
create table if not exists tag
(
    tag_id   int primary key auto_increment,
    tag_name varchar(20) not null
);

-- auto-generated definition
create table if not exists word_trans
(
    trans_id int primary key auto_increment,
    word_id  int          not null,
    trans    varchar(100) not null,
    constraint word_trans_pk2
        unique (trans),
    constraint word_trans_word_word_id_fk
        foreign key (word_id) references word (word_id)
);

-- auto-generated definition
create table if not exists english_word
(
    word_id         int         not null
        primary key,
    english_ukphone varchar(30) null,
    english_usphone varchar(30) null,
    constraint english_word_word_word_id_fk
        foreign key (word_id) references word (word_id)
);

-- auto-generated definition
create table if not exists japanese_word
(
    word_id           int         not null
        primary key,
    japanese_notation varchar(30) null,
    constraint japanese_word_word_word_id_fk
        foreign key (word_id) references word (word_id)
);

-- auto-generated definition
create table if not exists card_response
(
    card_response_id      int primary key auto_increment,
    card_id               int          not null,
    user_id               int          not null,
    card_response_type    tinyint      not null,
    card_response_content varchar(150) null,
    constraint card_response___fk
        foreign key (card_id) references card (card_id),
    constraint card_response_user_user_id_fk
        foreign key (user_id) references "user" (user_id)
);

-- auto-generated definition
create table if not exists card_tag
(
    card_id     int not null,
    tag_id      int not null,
    card_tag_id int primary key auto_increment,
    constraint card_tag_card_card_id_fk
        foreign key (card_id) references card (card_id),
    constraint card_tag_tag_tag_id_fk
        foreign key (tag_id) references tag (tag_id)
);

-- auto-generated definition
create table if not exists study_rec
(
    study_rec_id        int primary key auto_increment,
    word_id             int                                not null,
    user_id             int                                not null,
    study_count         int                                not null,
    study_rec_date_time datetime default CURRENT_TIMESTAMP not null,
    constraint study_rec_user_user_id_fk
        foreign key (user_id) references "user" (user_id),
    constraint study_rec_word_word_id_fk
        foreign key (word_id) references word (word_id)
);



