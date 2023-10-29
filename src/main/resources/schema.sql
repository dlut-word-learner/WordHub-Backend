create table if not exists wordhub.language
(
    lang_name varchar(20) primary key
)
    comment '语言';

create table if not exists wordhub.dict
(
    dict_id   int auto_increment
        primary key,
    lang_name   varchar(20)         not null,
    dict_name varchar(20) not null,
    constraint dict_language_lang_name_fk
        foreign key (lang_name) references wordhub.language (lang_name)
)
    comment '词典';

create table if not exists wordhub.tag
(
    tag_name varchar(20) not null primary key
)
    comment '卡片标签';

create table if not exists wordhub.user
(
    user_id          int auto_increment
        primary key,
    user_name        varchar(30)       not null comment '用户名',
    user_password    char(60)          not null comment '存储Bcrypt加密后的密码',
    user_email       varchar(50)       not null,
    user_score       int     default 0 not null,
    user_role        tinyint default 0 not null comment '0 普通用户 1管理员 其它预留',
    constraint user_pk_email
        unique (user_email),
    constraint user_pk_name
        unique (user_name)
)
    comment '用户';

create table if not exists wordhub.word
(
    word_id   int auto_increment
        primary key,
    word_name varchar(20) not null comment '"日语则为罗马音"',
    dict_id   int         not null,
    extension json,
    constraint word_dict_dict_id_fk
        foreign key (dict_id) references wordhub.dict (dict_id)
);

create table if not exists wordhub.card
(
    card_id      int auto_increment
        primary key,
    word_id      int                  not null,
    card_content varchar(200)         not null,
    is_public    tinyint(1) default 0 not null,
    user_id      int                  not null comment 'owner',
    constraint card_user_user_id_fk
        foreign key (user_id) references wordhub.user (user_id),
    constraint card_word_word_id_fk
        foreign key (word_id) references wordhub.word (word_id)
);

create table if not exists wordhub.card_response
(
    card_response_id      int auto_increment
        primary key,
    card_id               int          not null,
    user_id               int          not null,
    card_response_type    tinyint      not null,
    card_response_content varchar(150) null comment '举报信息',
    constraint card_response___fk
        foreign key (card_id) references wordhub.card (card_id),
    constraint card_response_user_user_id_fk
        foreign key (user_id) references wordhub.user (user_id)
);

create table if not exists wordhub.card_tag
(
    card_id     int not null,
    tag_name    varchar(20) not null,
    card_tag_id int auto_increment
        primary key,
    constraint card_tag_card_card_id_fk
        foreign key (card_id) references wordhub.card (card_id),
    constraint card_tag_tag_tag_name_fk
        foreign key (tag_name) references wordhub.tag (tag_name)
);

create table if not exists wordhub.study_rec
(
    study_rec_id        int auto_increment
        primary key,
    word_id             int                                not null,
    user_id             int                                not null,
    study_rec_gap int not null comment '间隔小时数',
    study_rec_ease REAL not null comment '简单值',
    study_rec_due_time datetime default CURRENT_TIMESTAMP not null comment '预计下次复习时间',
    constraint study_rec_user_user_id_fk
        foreign key (user_id) references wordhub.user (user_id),
    constraint study_rec_word_word_id_fk
        foreign key (word_id) references wordhub.word (word_id)
)
    comment '用户对单词的学习记录';

