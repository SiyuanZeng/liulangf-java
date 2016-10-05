/**
* 版权所有:(C)2001-2012 北京中油瑞飞信息技术有限责任公司
* Author : 刘余庆
* Creation time : 2012-11-6 下午4:21:48
* Description :
*/
package com.liulangf.thread.pool.ebus;

/**
 * 工作者线程工程类
 */
public interface WorkerProvider {
    
    WorkerThread newWorker();

}
