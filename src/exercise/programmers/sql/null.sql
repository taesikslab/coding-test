-- Null 처리하기
SELECT ANIMAL_TYPE, ifnull(name,'No name'), SEX_UPON_INTAKE from ANIMAL_INS;