package com.lzk.dto;

import com.lzk.entity.SuccessKilled;
import com.lzk.enums.SeckillStatEnum;

/**
 * Created by lzk on 2017/12/17 18:48
 * Description:
 */
public class SeckillExecution {
    private long seckillId;
    /* 执行秒杀结果的状态   */
    private int state;
    /* 状态的明文标示   */
    private String stateInfo;
    /*  当秒杀成功时，需要传递秒杀结果的对象回去  */
    private SuccessKilled successKilled;

    /*  秒杀成功返回的实体  */
    public SeckillExecution(long seckillId, SeckillStatEnum statEnum, SuccessKilled successKilled) {
        this.seckillId = seckillId;
        this.state = statEnum.getState();
        this.stateInfo = statEnum.getStateInfo();
        this.successKilled = successKilled;
    }

    /*  秒杀失败返回的实体  */
    public SeckillExecution(long seckillId, SeckillStatEnum statEnum) {
        this.seckillId = seckillId;
        this.state = statEnum.getState();
        this.stateInfo = statEnum.getStateInfo();
    }

    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public SuccessKilled getSuccessKilled() {
        return successKilled;
    }

    public void setSuccessKilled(SuccessKilled successKilled) {
        this.successKilled = successKilled;
    }

    @Override
    public String toString() {
        return "SeckillException{" +
                "秒杀的商品ID=" + seckillId +
                ", 秒杀状态=" + state +
                ", 秒杀状态信息='" + stateInfo + '\'' +
                ", 秒杀的商品=" + successKilled +
                '}';
    }
}
