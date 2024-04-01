-- 코드를 입력하세요
SELECT member_id, member_name, gender, to_char(date_of_birth, 'YYYY-MM-DD') as "date_of_birth"
from member_profile
where to_char(date_of_birth, 'MM') = '03' and tlno is not null and gender = 'W'
order by member_id asc;