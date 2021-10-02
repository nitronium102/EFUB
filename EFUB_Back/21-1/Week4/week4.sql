SELECT * FROM efub.members
inner join position on position.position_id = members.position_id
inner join team on team.team_id = members.team_id;