package com.wl.defined;

public class Constant {

    public final static String DELETED_FLAG_FIELD_NAME = "isDelete";

    public final static int NO = 0;
    public final static int YES = 1;

    public final static int SUCCESS = 0;
    public final static int FAIL = 1;

    public final static int LSTM_TRAIN_STATUS_ERROR = -1;   //训练任务失败
    public final static int LSTM_TRAIN_STATUS_INIT = 0;     //训练任务初始化
    public final static int LSTM_TRAIN_STATUS_QUERIED = 1;  //训练任务查询数据完成 50%
    public final static int LSTM_TRAIN_STATUS_FILED = 2;    //训练任务生产数据集完成 100%
    public final static int LSTM_TRAIN_STATUS_SEND = 3;     //训练任务模型初始化
    public final static int LSTM_TRAIN_STATUS_TRAINING = 4; //训练任务模型训练中
    public final static int LSTM_TRAIN_STATUS_FINISH = 5;   //训练任务模型成功
}
