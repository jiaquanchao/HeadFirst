import cx_Oracle


jdbcUrl = "192.168.0.210:1521/orcl"
user = "ATLASCOPCO_TOOLSNET"
password = "T00lsNetPwd"
con = cx_Oracle.connect(user, password, jdbcUrl)
print(con)
sql = "SELECT * FROM UNIT16574G"
cursor = con.cursor()

cursor.execute(sql)

result = cursor.fetchall()
count = cursor.rowcount
print("=====================")
print("Total:", count)
print("=====================")

