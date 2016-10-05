/**
* 版权所有:(C)2001-2012 北京中油瑞飞信息技术有限责任公司
* Author : 刘余庆
* Creation time : 2012-11-6 上午9:00:33
* Description :
*/
package com.liulangf.thread.pool.ebus;

import java.util.concurrent.ExecutorService;

/**
 *
 */
public interface ExecutorServiceFactory {

    /**
     * @return
     */
    ExecutorService newThreadPool();

}
