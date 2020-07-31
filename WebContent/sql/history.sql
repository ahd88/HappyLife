create schema spring;
use spring;
DROP TABLE hl_users;
CREATE TABLE HL_USERS(
	userId BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
    FNAME VARCHAR(50) NOT NULL,
	LNAME VARCHAR(20) NOT NULL,
	EMAIL VARCHAR(50) NOT NULL,
	USERNAME VARCHAR(15) NOT NULL,
	PASSWD VARCHAR(10) NOT NULL,
	GENDER VARCHAR(10) NOT NULL,
	LOOKINGIN VARCHAR(25) NOT NULL,
	PHONE VARCHAR(20) NOT NULL,
	IMAGE VARCHAR(50),
	DOB DATE NOT NULL,
	Age VARCHAR(5) NULL,
	RESIDENCY_STATUS VARCHAR(20),
	ABOUT_MYSELF VARCHAR(1000),
	LOOKING_FOR VARCHAR(1000),
	PUBLIC_PHOTO VARCHAR(50),
	LastLogin TIMESTAMP,
	ProfilePostedBy VARCHAR(10),
	EthnicOrigin VARCHAR(10),
	ReligiousHistory VARCHAR(15),
	HairColor VARCHAR(10),
	BodyType VARCHAR(10),
	Beard VARCHAR(10),
	Hijab_Beard VARCHAR(20),
	Height VARCHAR(10),
	Pray VARCHAR(20),
	Sect VARCHAR(10),
	MaritalStatus VARCHAR(10),
	Children VARCHAR(10),
	LikeToHaveChildren VARCHAR(10),
	Languages VARCHAR(10),
	Profession VARCHAR (30),
	HighestQual VARCHAR(10)
);

select * from hl_users;
/*
ALTER TABLE HL_USERS MODIFY COLUMN Age VARCHAR(5) NULL;
ALTER TABLE HL_USERS ALTER COLUMN RENAME country TO LOOKINGIN;
*/

CREATE TABLE LOOKING_FOR(
	ID BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	userId BIGINT NOT NULL references HL_USERS(userId),
	AgeL VARCHAR(5) NOT NULL,
	AgeH VARCHAR(5) NOT NULL,
	LOOKINGIN VARCHAR(100) NOT NULL,
	RESIDENCY_STATUS VARCHAR(50),
	WILLING_TO_RELOCATE VARCHAR(10) NOT NULL,
	EthnicOrigin VARCHAR(50) NOT NULL,
	ReligiousHistory VARCHAR(15) NOT NULL,
	Living_With_InLaws VARCHAR(25) NOT NULL,
	Pray VARCHAR(15) NOT NULL,
	Sect VARCHAR(10) NOT NULL,
	MaritalStatus VARCHAR(12) NOT NULL,
	HasChildren VARCHAR(10) NOT NULL,
	HasPDisability VARCHAR(10), 
	LikeToHaveChildren VARCHAR(10) NOT NULL,
	Polygamy VARCHAR(10),
	BodyType VARCHAR(20),
    HeightL VARCHAR(7),
    HeightH VARCHAR(7),
	Hijab_Beard VARCHAR(15),
	Profession VARCHAR(100),
	HighestQual VARCHAR(50),
	LOOKING_FOR VARCHAR(1000)
);

CREATE TABLE Messages(
	msgId BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
	senderId BIGINT NOT NULL,
	recipientId BIGINT NOT NULL,
	msgContent VARCHAR(1000),
	msgTime timestamp,
	msgRead boolean
);

CREATE TABLE viewed(
	id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
	uid1 BIGINT NOT NULL,
	uid2 BIGINT NOT NULL,
	historyContent VARCHAR(1000),
	user1vieweduser2 boolean,
    user2vieweduser1 boolean,
    user1inviteduser2 boolean,
    user2inviteduser1 boolean
);

UPDATE `spring`.`HL_USERS` SET `Sect` = 'SS', `MaritalStatus` = 'NM', `Profession` = 'itprofessional' WHERE (`userId` = '2');
UPDATE `spring`.`HL_USERS` SET `Sect` = 'SS', `MaritalStatus` = 'NM', `Profession` = 'Teacher' WHERE (`userId` = '3');
UPDATE `spring`.`HL_USERS` SET `Sect` = 'SS', `MaritalStatus` = 'NM', `Profession` = 'Other' WHERE (`userId` = '4');
UPDATE `spring`.`HL_USERS` SET `Sect` = 'SS', `MaritalStatus` = 'NM', `Profession` = 'Other' WHERE (`userId` = '5');
UPDATE `spring`.`HL_USERS` SET `Sect` = 'Sunni', `MaritalStatus` = 'NM', `Profession` = 'Engineer' WHERE (`userId` = '6');
UPDATE `spring`.`HL_USERS` SET `Sect` = 'Soufi', `MaritalStatus` = 'Divorced', `Profession` = 'Optician' WHERE (`userId` = '7');
UPDATE `spring`.`HL_USERS` SET `Sect` = 'Sunni', `MaritalStatus` = 'NM', `Profession` = 'Pharmacist' WHERE (`userId` = '8');
UPDATE `spring`.`HL_USERS` SET `Sect` = 'Salafi', `MaritalStatus` = 'NM', `Profession` = 'Pharmacist' WHERE (`userId` = '9');
UPDATE `spring`.`HL_USERS` SET `Sect` = 'SS' WHERE (`userId` = '1');
UPDATE `spring`.`HL_USERS` SET `Sect` = 'Sunni' WHERE (`userId` = '10');
UPDATE `spring`.`HL_USERS` SET `Sect` = 'Sunni', `MaritalStatus` = 'NM', `Profession` = 'semployed' WHERE (`userId` = '11');
UPDATE `spring`.`HL_USERS` SET `Sect` = 'Sunni', `MaritalStatus` = 'NM', `Profession` = 'sales' WHERE (`userId` = '12');
UPDATE `spring`.`HL_USERS` SET `Sect` = 'Sunni', `MaritalStatus` = 'NM', `Profession` = 'sales' WHERE (`userId` = '13');
UPDATE `spring`.`HL_USERS` SET `Sect` = 'Sunni', `MaritalStatus` = 'NM', `Profession` = 'Engineer' WHERE (`userId` = '14');
UPDATE `spring`.`HL_USERS` SET `Sect` = 'Sunni', `MaritalStatus` = 'NM', `Profession` = 'Lecturer' WHERE (`userId` = '15');
UPDATE `spring`.`HL_USERS` SET `Sect` = 'SS', `MaritalStatus` = 'NM', `Profession` = 'Teacher' WHERE (`userId` = '16');
UPDATE `spring`.`HL_USERS` SET `Sect` = 'Sunni', `MaritalStatus` = 'NM', `Profession` = 'Teacher' WHERE (`userId` = '17');

UPDATE `spring`.`HL_USERS` SET `Pray` = '5' WHERE (`userId` = '1');
UPDATE `spring`.`HL_USERS` SET `Pray` = '5' WHERE (`userId` = '2');
UPDATE `spring`.`HL_USERS` SET `Pray` = '5' WHERE (`userId` = '3');
UPDATE `spring`.`HL_USERS` SET `Pray` = '5' WHERE (`userId` = '4');
UPDATE `spring`.`HL_USERS` SET `Pray` = '5' WHERE (`userId` = '5');
UPDATE `spring`.`HL_USERS` SET `Pray` = '4' WHERE (`userId` = '6');
UPDATE `spring`.`HL_USERS` SET `Pray` = '3' WHERE (`userId` = '7');
UPDATE `spring`.`HL_USERS` SET `Pray` = '4' WHERE (`userId` = '8');
UPDATE `spring`.`HL_USERS` SET `Pray` = '4' WHERE (`userId` = '9');
UPDATE `spring`.`HL_USERS` SET `Pray` = '5' WHERE (`userId` = '10');
UPDATE `spring`.`HL_USERS` SET `Pray` = '4' WHERE (`userId` = '11');
UPDATE `spring`.`HL_USERS` SET `Pray` = '1' WHERE (`userId` = '12');
UPDATE `spring`.`HL_USERS` SET `Pray` = '4' WHERE (`userId` = '13');
UPDATE `spring`.`HL_USERS` SET `Pray` = '2' WHERE (`userId` = '14');
UPDATE `spring`.`HL_USERS` SET `Pray` = '3' WHERE (`userId` = '15');
UPDATE `spring`.`HL_USERS` SET `Pray` = '5' WHERE (`userId` = '16');
UPDATE `spring`.`HL_USERS` SET `Pray` = '4' WHERE (`userId` = '17');

UPDATE `spring`.`HL_USERS` SET `ReligiousHistory` = 'BM' WHERE (`userId` = '2');
UPDATE `spring`.`HL_USERS` SET `ReligiousHistory` = 'BM' WHERE (`userId` = '3');
UPDATE `spring`.`HL_USERS` SET `ReligiousHistory` = 'BM' WHERE (`userId` = '4');
UPDATE `spring`.`HL_USERS` SET `ReligiousHistory` = 'BM' WHERE (`userId` = '5');
UPDATE `spring`.`HL_USERS` SET `ReligiousHistory` = 'BM' WHERE (`userId` = '6');
UPDATE `spring`.`HL_USERS` SET `ReligiousHistory` = 'BM' WHERE (`userId` = '7');
UPDATE `spring`.`HL_USERS` SET `ReligiousHistory` = 'BM' WHERE (`userId` = '8');
UPDATE `spring`.`HL_USERS` SET `ReligiousHistory` = 'BM' WHERE (`userId` = '9');
UPDATE `spring`.`HL_USERS` SET `ReligiousHistory` = 'BM' WHERE (`userId` = '11');
UPDATE `spring`.`HL_USERS` SET `ReligiousHistory` = 'BM' WHERE (`userId` = '12');
UPDATE `spring`.`HL_USERS` SET `ReligiousHistory` = 'BM' WHERE (`userId` = '13');
UPDATE `spring`.`HL_USERS` SET `ReligiousHistory` = 'BM' WHERE (`userId` = '14');
UPDATE `spring`.`HL_USERS` SET `ReligiousHistory` = 'BM' WHERE (`userId` = '15');
UPDATE `spring`.`HL_USERS` SET `ReligiousHistory` = 'RM' WHERE (`userId` = '16');
UPDATE `spring`.`HL_USERS` SET `ReligiousHistory` = 'BM' WHERE (`userId` = '17');

UPDATE `spring`.`HL_USERS` SET `BodyType` = 'Average' WHERE (`userId` = '2');
UPDATE `spring`.`HL_USERS` SET `BodyType` = 'Slim' WHERE (`userId` = '3');
UPDATE `spring`.`HL_USERS` SET `BodyType` = 'Average' WHERE (`userId` = '4');
UPDATE `spring`.`HL_USERS` SET `BodyType` = 'Average' WHERE (`userId` = '1');
UPDATE `spring`.`HL_USERS` SET `BodyType` = 'Slim' WHERE (`userId` = '5');
UPDATE `spring`.`HL_USERS` SET `BodyType` = 'Average' WHERE (`userId` = '6');
UPDATE `spring`.`HL_USERS` SET `BodyType` = 'Muscular' WHERE (`userId` = '7');
UPDATE `spring`.`HL_USERS` SET `BodyType` = 'Average' WHERE (`userId` = '8');
UPDATE `spring`.`HL_USERS` SET `BodyType` = 'Average' WHERE (`userId` = '9');
UPDATE `spring`.`HL_USERS` SET `BodyType` = 'Average' WHERE (`userId` = '11');
UPDATE `spring`.`HL_USERS` SET `BodyType` = 'Average' WHERE (`userId` = '12');
UPDATE `spring`.`HL_USERS` SET `BodyType` = 'Muscular' WHERE (`userId` = '13');
UPDATE `spring`.`HL_USERS` SET `BodyType` = 'Slim' WHERE (`userId` = '14');
UPDATE `spring`.`HL_USERS` SET `BodyType` = 'preferN' WHERE (`userId` = '15');
UPDATE `spring`.`HL_USERS` SET `BodyType` = 'Average' WHERE (`userId` = '16');
UPDATE `spring`.`HL_USERS` SET `BodyType` = 'Average' WHERE (`userId` = '17');

UPDATE `spring`.`HL_USERS` SET `RESIDENCY_STATUS` = 'Citizen' WHERE (`userId` = '13');
UPDATE `spring`.`HL_USERS` SET `RESIDENCY_STATUS` = 'svisa' WHERE (`userId` = '14');
UPDATE `spring`.`HL_USERS` SET `RESIDENCY_STATUS` = 'Citizen' WHERE (`userId` = '10');
UPDATE `spring`.`HL_USERS` SET `RESIDENCY_STATUS` = 'Citizen' WHERE (`userId` = '11');
UPDATE `spring`.`HL_USERS` SET `RESIDENCY_STATUS` = 'Citizen' WHERE (`userId` = '12');
UPDATE `spring`.`HL_USERS` SET `RESIDENCY_STATUS` = 'Citizen' WHERE (`userId` = '15');
UPDATE `spring`.`HL_USERS` SET `RESIDENCY_STATUS` = 'Citizen' WHERE (`userId` = '16');
UPDATE `spring`.`HL_USERS` SET `RESIDENCY_STATUS` = 'Citizen' WHERE (`userId` = '17');
UPDATE `spring`.`HL_USERS` SET `RESIDENCY_STATUS` = 'Citizen' WHERE (`userId` = '5');
UPDATE `spring`.`HL_USERS` SET `RESIDENCY_STATUS` = 'Citizen' WHERE (`userId` = '1');
UPDATE `spring`.`HL_USERS` SET `RESIDENCY_STATUS` = 'Citizen' WHERE (`userId` = '2');
UPDATE `spring`.`HL_USERS` SET `RESIDENCY_STATUS` = 'Citizen' WHERE (`userId` = '3');
UPDATE `spring`.`HL_USERS` SET `RESIDENCY_STATUS` = 'Citizen' WHERE (`userId` = '4');
UPDATE `spring`.`HL_USERS` SET `RESIDENCY_STATUS` = 'svisa' WHERE (`userId` = '6');
UPDATE `spring`.`HL_USERS` SET `RESIDENCY_STATUS` = 'Citizen' WHERE (`userId` = '7');
UPDATE `spring`.`HL_USERS` SET `RESIDENCY_STATUS` = 'svisa' WHERE (`userId` = '8');
UPDATE `spring`.`HL_USERS` SET `RESIDENCY_STATUS` = 'svisa' WHERE (`userId` = '9');

UPDATE `spring`.`HL_USERS` SET `LOOKINGIN` = 'India' WHERE (`userId` = '12');
UPDATE `spring`.`HL_USERS` SET `LOOKINGIN` = 'India' WHERE (`userId` = '13');

UPDATE `spring`.`HL_USERS` SET `IMAGE` = 'manonymous.png' WHERE (`userId` = '16');
UPDATE `spring`.`HL_USERS` SET `IMAGE` = 'fanonymous.png' WHERE (`userId` = '17');
UPDATE `spring`.`HL_USERS` SET `IMAGE` = 'manonymous.png' WHERE (`userId` = '14');
UPDATE `spring`.`HL_USERS` SET `IMAGE` = 'manonymous.png' WHERE (`userId` = '13');
UPDATE `spring`.`HL_USERS` SET `IMAGE` = 'manonymous.png' WHERE (`userId` = '12');
UPDATE `spring`.`HL_USERS` SET `IMAGE` = 'manonymous.png' WHERE (`userId` = '10');
UPDATE `spring`.`HL_USERS` SET `IMAGE` = 'fanonymous.png' WHERE (`userId` = '15');
UPDATE `spring`.`HL_USERS` SET `IMAGE` = 'fanonymous.png' WHERE (`userId` = '11');

UPDATE `spring`.`hl_users` SET `EthnicOrigin`='Arab' WHERE `userId`='4';
UPDATE `spring`.`hl_users` SET `EthnicOrigin`='Asian' WHERE `userId`='2';
UPDATE `spring`.`hl_users` SET `EthnicOrigin`='Asian' WHERE `userId`='3';
UPDATE `spring`.`hl_users` SET `EthnicOrigin`='Asian' WHERE `userId`='5';
UPDATE `spring`.`hl_users` SET `EthnicOrigin`='Arab' WHERE `userId`='6';
UPDATE `spring`.`hl_users` SET `EthnicOrigin`='Arab' WHERE `userId`='7';
UPDATE `spring`.`hl_users` SET `EthnicOrigin`='Arab' WHERE `userId`='9';
UPDATE `spring`.`hl_users` SET `EthnicOrigin`='Arab' WHERE `userId`='11';
UPDATE `spring`.`hl_users` SET `EthnicOrigin`='Asian' WHERE `userId`='12';
UPDATE `spring`.`hl_users` SET `EthnicOrigin`='Asian' WHERE `userId`='13';
UPDATE `spring`.`hl_users` SET `EthnicOrigin`='Asian' WHERE `userId`='14';
UPDATE `spring`.`hl_users` SET `EthnicOrigin`='Arab' WHERE `userId`='15';
UPDATE `spring`.`hl_users` SET `EthnicOrigin`='African' WHERE `userId`='16';

UPDATE `spring`.`hl_users` SET `Hijab_Beard`='Always' WHERE `userId`='4';
UPDATE `spring`.`hl_users` SET `Hijab_Beard`='Always' WHERE `userId`='3';
UPDATE `spring`.`hl_users` SET `Hijab_Beard`='Yes' WHERE `userId`='2';
UPDATE `spring`.`hl_users` SET `Hijab_Beard`='Yes' WHERE `userId`='5';
UPDATE `spring`.`hl_users` SET `Hijab_Beard`='No' WHERE `userId`='6';
UPDATE `spring`.`hl_users` SET `Hijab_Beard`='Sometimes' WHERE `userId`='7';
UPDATE `spring`.`hl_users` SET `Hijab_Beard`='Yes' WHERE `userId`='8';
UPDATE `spring`.`hl_users` SET `Hijab_Beard`='Yes' WHERE `userId`='9';
UPDATE `spring`.`hl_users` SET `Hijab_Beard`='Always' WHERE `userId`='11';
UPDATE `spring`.`hl_users` SET `Hijab_Beard`='Yes' WHERE `userId`='12';
UPDATE `spring`.`hl_users` SET `Hijab_Beard`='No' WHERE `userId`='13';
UPDATE `spring`.`hl_users` SET `Hijab_Beard`='Yes' WHERE `userId`='14';
UPDATE `spring`.`hl_users` SET `Hijab_Beard`='Always' WHERE `userId`='15';
UPDATE `spring`.`hl_users` SET `Hijab_Beard`='Yes' WHERE `userId`='16';
UPDATE `spring`.`hl_users` SET `Height`='180' WHERE `userId`='3';
UPDATE `spring`.`hl_users` SET `Height`='178' WHERE `userId`='2';
UPDATE `spring`.`hl_users` SET `Height`='181' WHERE `userId`='5';
UPDATE `spring`.`hl_users` SET `Height`='179' WHERE `userId`='6';
UPDATE `spring`.`hl_users` SET `Height`='169' WHERE `userId`='7';
UPDATE `spring`.`hl_users` SET `Height`='179' WHERE `userId`='8';
UPDATE `spring`.`hl_users` SET `Height`='181' WHERE `userId`='9';
UPDATE `spring`.`hl_users` SET `Height`='170' WHERE `userId`='11';
UPDATE `spring`.`hl_users` SET `Height`='177' WHERE `userId`='12';
UPDATE `spring`.`hl_users` SET `Height`='176' WHERE `userId`='13';
UPDATE `spring`.`hl_users` SET `Height`='182' WHERE `userId`='14';
UPDATE `spring`.`hl_users` SET `Height`='159' WHERE `userId`='15';
UPDATE `spring`.`hl_users` SET `Height`='180' WHERE `userId`='16';



/* for pure match hassan & asma */
UPDATE `spring`.`looking_for` SET `AgeL` = '24', `AgeH` = '35', `LOOKINGIN` = 'Sudan', `RESIDENCY_STATUS` = 'Citizen', `EthnicOrigin` = 'Arab', `ReligiousHistory` = 'BM', `Pray` = '5', `Sect` = 'Sunni', `MaritalStatus` = 'NM', `HasChildren` = 'None', `LikeToHaveChildren` = 'Yes', `BodyType` = 'Average', `HeightL` = '170', `HeightH` = '180', `Hijab_Beard` = 'Always', `Profession` = 'Other' WHERE (`ID` = '8');
UPDATE `spring`.`HL_USERS` SET `Sect` = 'Sunni' WHERE (`userId` = '4');
UPDATE `spring`.`hl_users` SET `Hijab_Beard`='Always' WHERE `userId`='4';
UPDATE `spring`.`hl_users` SET `Height`='175' WHERE `userId`='4';

UPDATE `spring`.`looking_for` SET `RESIDENCY_STATUS`='dontmind' WHERE `ID`='4';
UPDATE `spring`.`looking_for` SET `AgeL` = '29', `AgeH` = '40', `LOOKINGIN` = 'Sudan', `RESIDENCY_STATUS` = 'Citizen', `EthnicOrigin` = 'Arab', `ReligiousHistory` = 'dontmind', `Living_With_InLaws` = 'wc', `Pray` = '5', `Sect` = 'Sunni', `MaritalStatus` = 'NM', `HasChildren` = 'None', `LikeToHaveChildren` = 'Yes', `BodyType` = 'Average', `HeightL` = '170', `HeightH` = '182', `Hijab_Beard` = 'dontmind', `Profession` = 'Pharmacist' WHERE (`ID` = '4');
UPDATE `spring`.`HL_USERS` SET `EthnicOrigin` = 'Arab' WHERE (`userId` = '8');
UPDATE `spring`.`HL_USERS` SET `Pray` = '5' WHERE (`userId` = '8');
UPDATE `spring`.`hl_users` SET `EthnicOrigin`='Arab' WHERE `userId`='4';
/* for pure match hassan & asma */

ALTER TABLE Messages ADD FOREIGN KEY (senderId) REFERENCES HL_USERS (userId);

select * from hl_users;
select * from looking_for;
select * from Viewed;

select * from hl_users where (lookingin='Sudan' or lookingin='dontmind') and (ethnicorigin='Arab' or ethnicorigin='dontmind') and (bodytype='Average' or bodytype='dontmind') and (pray>='5' or pray='dontmind') and (sect='Sunni' or sect='dontmind') and (maritalstatus='NM' or maritalstatus='dontmind') and (profession='Pharmacist' or profession='dontmind' or profession='Other') and gender='M';
select userId from looking_for where (lookingin='Sudan' or lookingin='dontmind') and (ethnicorigin='Arab' or ethnicorigin='dontmind') and (bodytype='Average' or bodytype='dontmind') and (hijab_beard='Always' or hijab_beard='dontmind') and (pray>='5' or pray='dontmind') and (sect='SS' or sect='dontmind') and (maritalstatus='NM' or maritalstatus='dontmind') and (profession='Other' or profession='dontmind' or profession='Other');

select * from hl_users where (lookingin='Sudan' or lookingin='dontmind') and (ethnicorigin='Arab' or ethnicorigin='dontmind') and (bodytype='Average' or bodytype='dontmind') and (pray>='5' or pray='dontmind') and (sect='Sunni' or sect='dontmind') and (maritalstatus='NM' or maritalstatus='dontmind') and (profession='Pharmacist' or profession='dontmind' or profession='Other') and gender='M';

select userId from looking_for where (lookingin='Sudan' or lookingin='dontmind') and (ethnicorigin='Arab' or ethnicorigin='dontmind') and (bodytype='Average' or bodytype='dontmind') and (hijab_beard='Always' or hijab_beard='dontmind') and (pray>='5' or pray='dontmind') and (sect='SS' or sect='dontmind') and (maritalstatus='NM' or maritalstatus='dontmind') and (profession='Other' or profession='dontmind' or profession='Other');


create schema test;
use test;
create table NewLineDemo ( CountryName varchar(10) );
insert into NewLineDemo values('US');
insert into NewLineDemo values('UK');
insert into NewLineDemo values('AUS');

select *from NewLineDemo;
select concat_ws('\n',CountryName) as CountryList from NewLineDemo;

use spring;
select * from viewed;
select * from hl_users;
truncate table viewed;
UPDATE `spring`.`viewed` SET `historyContent` = 'Asma viewed Hassan\'s profile, Hassan viewed Asma\'s profile' 
	WHERE (`id` = '1');
update viewed set historyContent='' where uid1='' and uid2='';
SELECT CONCAT(c.historyContent, ' Hassan viewed Asma profile') AS historyContent, c.* 
	FROM `viewed` c where uid1='4';


select * from viewed where uid2='1' and user1vieweduser2=true;