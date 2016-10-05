package com.liulangf.pattern.gof.behavioral.template_method;

/**
 * Callback + template 是一个绝配。 见spring HibernateTemplate等实现。
 * 
 * 
 * @author LiuYuQing
 * @version 1.0 2010-6-12
 */
public class CallbackTemplate {
	//-----------------callback + template + 第三方接口---------------------
	interface Redis {
		public void init();
		public void hello();
		public void quit();
	}
	
	interface RedisFactory {
		public Redis getRedis();
	}
	
	private RedisFactory factory = new RedisFactory() {
		@Override public Redis getRedis() {
			return new Redis() {
				@Override public void init() {
					System.out.println("init()");
				}
				@Override public void quit() {
					System.out.println("quit()");
				}
				@Override public void hello() {
					System.out.println("HelloWorld");
				}
			};
		}
	};
	
	interface Callback {
		public void doInRedis(Redis redis) throws Exception;
	}
	
	public class RedisTemplate {
		public void execute(Callback callback) {
			Redis redis = factory.getRedis();
			try {
				redis.init();
				callback.doInRedis(redis);
			} catch (Exception e) {
				throw new RuntimeException("Something wrong happened.", e);
			} finally {
				redis.quit();
			}
		}
		
		public void helloWorld() {
			execute(new Callback() {
				@Override
				public void doInRedis(Redis redis) throws Exception {
					redis.hello();
				}
			});
		}
	}
	
	//-----------------------simple callback----------------------------------
	private abstract class AbstractCallback {
		public void run() {
			Redis redis = factory.getRedis();
			try {
				redis.init();
				execute(redis);
			} catch (Exception e) {
			} finally {
				redis.quit();
			}
		}
		abstract protected void execute(Redis redis) throws Exception;
		
	}
	
	public void helloWorld() {
		new AbstractCallback() {
			@Override 
			public void execute(Redis redis) throws Exception {
				redis.hello();
			}
		}.run();
	}
	
	public static void main(String...args) {
		new CallbackTemplate().new RedisTemplate().helloWorld();
		new CallbackTemplate().helloWorld();
		new CallbackTemplate().new RedisTemplate().execute(new Callback() {
		    public void doInRedis(Redis redis) throws Exception {
		        //....
		    }
		});
	}
	

}
