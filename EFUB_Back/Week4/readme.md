21.04.10 Week4 back seminar
=====

# 01. MySQL
-----
## 1. Table
### 1) members table
<img src = "members.png">

### 2) position table
<img src = "position.png">

### 3) team
<img src = "team.png">

## 2. Code
```sql
SELECT * FROM efub.members
inner join position on position.position_id = members.position_id
inner join team on team.team_id = members.team_id;
```

## 3. Output
<img src = "join_result.png">


# 02. AWS
-----
## 1. Original picture
<img src = "HappyFace.jpg">

## 2. Resized picture
<img src = "HappyFace_resized.jpg">
