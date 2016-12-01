import cx_Oracle  # 引用模块cx_Oracle
import pandas as pd


def get(dbname='ATLASCOPCO_TOOLSNET', key='T00lsNetPwd', host='192.168.0.210', servicename='orcl'):
    """
    :param dbname: 数据库用户名
    :param key: 数据库密码
    :param host: 数据库ip
    :param servicename: 数据库SID或者service name
    :return:
    """
    return cx_Oracle.Connection(dbname + '/' + key + '@' + host + '/' + servicename)  # 连接数据库
    # conn = cx_Oracle.connect(dbname + '/' + key + '@' + host + '/' + servicename)    # 连接数据库
    # c = conn.cursor()                                           # 获取cursor
    # x = c.execute("select \"id\" from \"tool\"")                   # 使用cursor进行各种操作
    # print(x.fetchone())
    # c.close()                                                 # 关闭cursor
    # conn.close()


def selectByUnit(db, UnitID=702):
    # sql = ("SELECT * FROM \"Unit\"\
    #        WHERE \"UnitID\"="+str(UnitID))
    sql = ("SELECT * FROM \"Unit\" WHERE \"ID\"=701")
    cursor = db.cursor()
    ori_data = cursor.execute(sql)
    temp_list = []
    data_iterate = ori_data.fetchall()
    for element in data_iterate:
        # print(element)
        temp_list.append(list(element))

    cursor.close()
    df_tem = pd.DataFrame(temp_list)
    return df_tem


if __name__ == '__main__':
    db = get()
    df = selectByUnit(db)
    print(df)
    db.close()
