CREATE DATABASE IF NOT EXISTS `grading`;
USE `grading`;

--
-- Table structure for table `student`
--
DROP TABLE IF EXISTS `attends`;
DROP TABLE IF EXISTS `student`;
DROP TABLE IF EXISTS `course`;
DROP TABLE IF EXISTS `instructor`;
DROP TABLE IF EXISTS `authorities`;
DROP TABLE IF EXISTS `users`;



create table `users` (
	`instructor_Id` int NOT NULL,
	`first_Name` varchar(45) DEFAULT NULL,
	`last_Name` varchar(45) DEFAULT NULL,
	`email` varchar(45) DEFAULT NULL,
	`gender` varchar(6) DEFAULT NULL,
	`department` varchar(45) DEFAULT NULL,
    username varchar(50) not null primary key,
    password varchar(120) not null,
    enabled boolean not null
);

create table `authorities` (
    username varchar(50) not null,
    authority varchar(50) not null,
    foreign key (username) references users (username)
);


CREATE TABLE `course` (
  `course_Id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `instructor_Id` int DEFAULT NULL,
  `year`int DEFAULT NULL,
  `semester`varchar(10) DEFAULT NULL,
  `type`varchar(45) DEFAULT NULL,
  `ects`float(4) DEFAULT NULL,
  `dm`int DEFAULT NULL,
  `department`varchar(45) DEFAULT NULL,  
  `description`varchar(450) DEFAULT NULL,
  `syllabus`varchar(450) DEFAULT NULL,
  PRIMARY KEY (`course_Id`)

) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `student` (
    `student_Id` INT NOT NULL AUTO_INCREMENT,
    `course_Id` INT,
    `first_Name` VARCHAR(45) DEFAULT NULL,
    `last_Name` VARCHAR(45) DEFAULT NULL,
    `am` INT DEFAULT NULL,
    `gender` VARCHAR(6) DEFAULT NULL,
    `registration_Year` INT DEFAULT NULL,
    `registration_Semester` VARCHAR(45) DEFAULT NULL,
    `lab_Grade` float DEFAULT NULL,
    `final_Grade` float DEFAULT NULL,
    `email` VARCHAR(45) DEFAULT NULL,
    `department` VARCHAR(45) DEFAULT NULL,
    `graduate_Status` VARCHAR(45) DEFAULT NULL,
    PRIMARY KEY (`student_Id`)
)  ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=LATIN1;

-- CREATE TABLE `attends`(
--	`student_Id` int NOT NULL AUTO_INCREMENT,
--    `course_Id` int,
--    PRIMARY KEY (`student_Id`, `course_Id`)
--	FOREIGN KEY (`student_Id`) references `student`(`student_Id`)
--    FOREIGN KEY (`course_Id`) REFERENCES `course`(`course_Id`)
-- ) AUTO_INCREMENT=1;
--
-- Data for table `instructor`
--

-- insert into users(username, password, enabled)values('vlakas','{noop}vlakas',true);
-- insert into users(username, password, enabled)values('pvassil','pvassil',true);

-- insert into authorities(username,authority)values('vlakas','ROLE_USER');




INSERT INTO `users` VALUES 
(1,'Charles','Xavier','charles@xman.com', 'male', 'X-Men', 'professorx', '{noop}xmen',true),

(2,'Stephen','Strange','strange@dr.mcu', 'male', 'Strange Academy', 'drstrange', '{noop}multiverse', true),
(3,'Wade','Wilson','wadew@dead.mut', 'male', 'CSE', 'deadpool', '{noop}mrpool', true);

-- ('LeslieA', 'LeslieAndrews');


insert into authorities(username,authority)values('professorx','ROLE_USER');
insert into authorities(username,authority)values('drstrange','ROLE_USER');
insert into authorities(username,authority)values('deadpool','ROLE_ADMIN');



INSERT INTO `course` VALUES
	(1, 'Telepathy', 1, 2012, 'Fall', 'Mandatory', 7.5, 5, 'Superheroing','Lame', 'Everything'),
    (2, 'Mutant History', 1, 2002, 'Fall', 'Mandatory', 8, 6, 'South Parking','Na doume ti sthn euxh ta 8eloume auta ta description', 'Education'),
	(3, 'How to break the 4th Wall', 3, 2002, 'Fall', 'Mandatory', 8, 6, 'Dead Pooling','Time to make the chimichangas', 'Broken'),
    (4, 'Dark arts', 2, 2007, 'Fall', 'Mandatory', 6, 6, 'Dead Pooling','Strange Academy', 'First and second Chapters of the Book of Vishanti'),
    (5, 'Conjuring', 2, 2004, 'Fall', 'Mandatory', 7, 6, 'Dead Pooling','Strange Academy', 'Fourth Chapter of the Book of Vishanti');

INSERT INTO `student` VALUES 
	(1, 1, 'Jean', 'Grey', 52, 'Female', 2002, 'Fall', 7, 8, 'jeang@xman.mu', 'Theory of Everything', 'UnderGraduate'),
    (2, 1, 'Emma', 'Frost', 105, 'Female', 2003, 'Fall', 2, 3, 'emmaf@xman.mu', 'Theory of Everything', 'UnderGraduate'),
    (3, 1, 'Nathan', 'Summers (Cable)', 616, 'Male', 2005, 'Fall', 5, 7, 'natsum@mar.mu', 'Travelling', 'UnderGraduate'),
    (4, 2, 'Scott', 'Summers (Cyclops)', 617, 'Male', 2005, 'Fall', 8, 9, 'cycl@xman.mu', 'Theory of Everything', 'UnderGraduate'),
    (5, 2, 'Robert', 'Drake (Iceman)', 618, 'Male', 2006, 'Spring', 5, 5, 'robd@xman.mu', 'Theory of Everything', 'UnderGraduate'),
    (6, 2, 'Rony', 'Lebeau (Gambit)', 619, 'Male', 2006, 'Spring', 6, 7, 'ronleb@xman.mu', 'Theory of Everything', 'UnderGraduate'),
    (7, 2, 'Anna', 'Marie', 620, 'Female', 2006, 'Spring', 6, 9, 'annam@xman.mu', 'Theory of Everything', 'UnderGraduate'),
    (8, 3, 'Jennifer', 'Walters', 630, 'Female', 2007, 'Spring', 5, 8, 'shehulk@marvel.mu', 'Theory of Everything', 'UnderGraduate');
