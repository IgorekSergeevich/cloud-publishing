DROP DATABASE IF EXISTS `cloud-publishing`;

CREATE DATABASE IF NOT EXISTS `cloud-publishing`;

USE `cloud-publishing`;

CREATE TABLE `article` (
  `id`            int          NOT NULL AUTO_INCREMENT,
  `publishing_id` int          NOT NULL,
  `topic_id`      int          NOT NULL,
  `title`         varchar(255) NOT NULL,
  `content`       TEXT         NOT NULL,
  `author_login`  varchar(20)  NOT NULL UNIQUE,
  PRIMARY KEY (`id`)
) CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE `topic` (
  `id`   int          NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE `profile` (
  `id`           int          NOT NULL AUTO_INCREMENT,
  `employee_login`       varchar(20) NOT NULL UNIQUE,
  `sex`          char(1)      NOT NULL,
  `birth_year`   smallint     NOT NULL,
  `address`      varchar(255) NOT NULL,
  `type`         varchar(20)  NOT NULL,
  `education_id` int,
  `chief_editor` bool         NOT NULL DEFAULT FALSE,
  PRIMARY KEY (`id`)
) CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE `education` (
  `id`    int          NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE `article_coauthors` (
  `article_id`  int NOT NULL,
  `employee_login` varchar(20) NOT NULL UNIQUE,
  PRIMARY KEY (`article_id`, `employee_login`)
) CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE `publishing` (
  `id`       int          NOT NULL AUTO_INCREMENT,
  `title`    varchar(255) NOT NULL,
  `type`     char(1)      NOT NULL,
  `subjects` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE `publishing_topic` (
  `publishing_id` int NOT NULL,
  `topic_id`      int NOT NULL,
  PRIMARY KEY (`publishing_id`, `topic_id`)
) CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE `publishing_employee` (
  `employee_login`   varchar(20) NOT NULL UNIQUE,
  `publishing_id` int NOT NULL,
  PRIMARY KEY (`employee_login`, `publishing_id`)
) CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE `review` (
  `article_id` int  NOT NULL,
  `employee_login` varchar(20) NOT NULL UNIQUE,
  `content`    TEXT NOT NULL,
  `approved`   bool NOT NULL DEFAULT FALSE,
  PRIMARY KEY (`article_id`, `employee_login`)
) CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE `issue` (
  `id`            int         NOT NULL AUTO_INCREMENT,
  `publishing_id` int         NOT NULL,
  `number`        varchar(50) NOT NULL,
  `date`          DATE        NOT NULL,
  `published`     bool        NOT NULL DEFAULT FALSE,
  PRIMARY KEY (`id`)
) CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE `issue_article` (
  `article_id` int NOT NULL,
  `issue_id`   int NOT NULL,
  PRIMARY KEY (`article_id`, `issue_id`)
) CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE `advertising` (
  `id`        int          NOT NULL AUTO_INCREMENT,
  `issue_id`  int          NOT NULL,
  `file_path` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE `mailing` (
  `id`            int NOT NULL AUTO_INCREMENT,
  `publishing_id` int NOT NULL,
  PRIMARY KEY (`id`)
) CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE `mailing_subscriber` (
  `mailing_id` int          NOT NULL,
  `email`      varchar(255) NOT NULL,
  PRIMARY KEY (`mailing_id`, `email`)
) CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE `mailing_result` (
  `mailing_id` int      NOT NULL,
  `issue_id`   int      NOT NULL,
  `date`       DATETIME NOT NULL,
  `result`     TEXT DEFAULT NULL,
  PRIMARY KEY (`mailing_id`, `issue_id`)
) CHARACTER SET utf8 COLLATE utf8_general_ci;

ALTER TABLE `article`
  ADD CONSTRAINT `article_fk0` FOREIGN KEY (`topic_id`) REFERENCES `topic` (`id`);

ALTER TABLE `article`
  ADD CONSTRAINT `article_publishing_fk1` FOREIGN KEY (`publishing_id`) REFERENCES `publishing` (`id`);

ALTER TABLE `profile`
  ADD CONSTRAINT `profile_fk0` FOREIGN KEY (`education_id`) REFERENCES `education` (`id`);

ALTER TABLE `article_coauthors`
  ADD CONSTRAINT `article_coauthors_fk0` FOREIGN KEY (`article_id`) REFERENCES `article` (`id`);

ALTER TABLE `publishing_topic`
  ADD CONSTRAINT `publishing_topic_fk0` FOREIGN KEY (`publishing_id`) REFERENCES `publishing` (`id`);

ALTER TABLE `publishing_topic`
  ADD CONSTRAINT `publishing_topic_fk1` FOREIGN KEY (`topic_id`) REFERENCES `topic` (`id`);

ALTER TABLE `publishing_employee`
  ADD CONSTRAINT `publishing_employee_fk0` FOREIGN KEY (`publishing_id`) REFERENCES `publishing` (`id`);

ALTER TABLE `review`
  ADD CONSTRAINT `review_fk0` FOREIGN KEY (`article_id`) REFERENCES `article` (`id`);

ALTER TABLE `issue`
  ADD CONSTRAINT `issue_fk0` FOREIGN KEY (`publishing_id`) REFERENCES `publishing` (`id`);

ALTER TABLE `issue_article`
  ADD CONSTRAINT `issue_article_fk0` FOREIGN KEY (`article_id`) REFERENCES `article` (`id`);

ALTER TABLE `issue_article`
  ADD CONSTRAINT `issue_article_fk1` FOREIGN KEY (`issue_id`) REFERENCES `issue` (`id`);

ALTER TABLE `advertising`
  ADD CONSTRAINT `advertising_fk0` FOREIGN KEY (`issue_id`) REFERENCES `issue` (`id`);

ALTER TABLE `mailing`
  ADD CONSTRAINT `mailing_fk0` FOREIGN KEY (`publishing_id`) REFERENCES `publishing` (`id`);

ALTER TABLE `mailing_subscriber`
  ADD CONSTRAINT `mailing_subscriber_fk0` FOREIGN KEY (`mailing_id`) REFERENCES `mailing` (`id`);

ALTER TABLE `mailing_result`
  ADD CONSTRAINT `mailing_result_fk0` FOREIGN KEY (`mailing_id`) REFERENCES `mailing` (`id`);

ALTER TABLE `mailing_result`
  ADD CONSTRAINT `mailing_result_fk1` FOREIGN KEY (`issue_id`) REFERENCES `issue` (`id`);
