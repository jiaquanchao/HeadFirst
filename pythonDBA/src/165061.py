import pandas as pd
import matplotlib.pyplot as plt
import numpy as np

#��һ��ͣ�ٵ��Լ��torque=100~200֮�䣬���������������ϣ��Ҽ�������λ�ü���һ��ͣ�ٴ�
def linear_fit(x,y):
    mat_x=np.ones((len(x),2))
    mat_x[:,1]=x
    y=np.array(y).reshape(len(y))
    w=np.dot(np.dot(np.linalg.inv(np.dot(mat_x.T,mat_x)),mat_x.T),y.T)
    resid=y-np.dot(mat_x,w.T).T
    return np.abs(resid),w


def dataRead(path):
    df=pd.read_csv(path)

    tor=df['ProcessTorque']
    cor=df['ProcessAngle']
    
 
    
    index_tor_100=-1
    index_tor_200=-1
    
    for i in range(tor.shape[0]):
        if index_tor_100==-1 and tor[i]>=100:
            index_tor_100=i
        elif index_tor_200==-1 and tor[i]>=200:
            index_tor_200=i
            break
    
    resid,w=linear_fit(list(cor[index_tor_100:index_tor_200]),list(tor[index_tor_100:index_tor_200]))

    val_max=resid[0]
    index_max=0
    for i in range(resid.shape[0]):
        if val_max< resid[i]:
            val_max=resid[i]
            index_max=i
#ͣ�ٵ�λ��
    stop_1=cor[index_max+index_tor_100]
    stop_1=cor[index_max+index_tor_100]+70
    stop_3=cor[index_max+index_tor_100]+140
    print (stop_1)
    
#   tm=[0]*index_tor_100+list(resid)+[0]*(cor.shape[0]-index_tor_400)
#   plt.scatter(cor,tm,s=5,c='r',label='resid')
    plt.scatter(cor,tor,s=2,c='b',label='torque')
#�ӵ�һ��ͣ�ٵ�stop_1��ʼ��ȡ
    new_cor=cor[index_max+index_tor_100:]
    new_tor=tor[index_max+index_tor_100:]
    plt.scatter(new_cor,new_tor,s=2,c='r',label='torque')
    plt.legend(loc='best')
    plt.grid
    plt.title(path)
    plt.show()
	
	
dataRead(r'D:\WCData\ReadBlob\16506_216344388.csv')