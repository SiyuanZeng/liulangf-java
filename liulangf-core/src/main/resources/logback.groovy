//
// Built on Mon Jan 24 09:34:09 CET 2011 by logback-translator
// For more information on configuration files in Groovy
// please see http://logback.qos.ch/manual/groovy.html

// For assistance related to this tool or configuration files
// in general, please contact the logback user mailing list at
//    http://qos.ch/mailman/listinfo/logback-user

// For professional support please see
//   http://www.qos.ch/shop/products/professionalSupport

import ch.qos.logback.classic.PatternLayout
import ch.qos.logback.core.ConsoleAppender
import ch.qos.logback.core.rolling.FixedWindowRollingPolicy
import ch.qos.logback.core.rolling.RollingFileAppender
import ch.qos.logback.core.rolling.SizeBasedTriggeringPolicy

import static ch.qos.logback.classic.Level.DEBUG
import static ch.qos.logback.classic.Level.ERROR
import static ch.qos.logback.classic.Level.INFO
import static ch.qos.logback.classic.Level.WARN

def loghome = "/backup/liulangf/logs/core"

appender("CONSOLE", ConsoleAppender) {
  layout(PatternLayout) {
	pattern = "%d{HH:mm:ss.SSS} [%thread] [%-5p] %logger{36} %line - %m%n"
  }
}
appender("FILE", RollingFileAppender) {
  file = "${loghome}/liulangf.log"
  rollingPolicy(FixedWindowRollingPolicy) {
	fileNamePattern = "${loghome}/liulangf.%i.log.zip"
	minIndex = 1
	maxIndex = 9
  }
  triggeringPolicy(SizeBasedTriggeringPolicy) {
	maxFileSize = "5MB"
  }
  layout(PatternLayout) {
	pattern = "%d{HH:mm:ss.SSS} [%thread] [%-5p] %logger{36} %line - %m%n"
  }
}
appender("ACCESS", RollingFileAppender) {
  file = "${loghome}/access.log"
  rollingPolicy(FixedWindowRollingPolicy) {
	fileNamePattern = "${loghome}/access.%i.log.zip"
	minIndex = 1
	maxIndex = 9
  }
  layout(PatternLayout) {
	pattern = "%d %m%n"
  }
  triggeringPolicy(SizeBasedTriggeringPolicy) {
	maxFileSize = "5MB"
  }
}
appender("IMPORT.EXPORT", RollingFileAppender) {
  file = "${loghome}/import.export.log"
  layout(PatternLayout) {
	pattern = "%date [%-5level] (%logger{32}:%line) %message%n"
  }
  rollingPolicy(FixedWindowRollingPolicy) {
	fileNamePattern = "${loghome}/import.export.%i.log.zip"
	maxIndex = 13
  }
  triggeringPolicy(SizeBasedTriggeringPolicy) {
	maxFileSize = "10MB"
  }
}
appender("TRAFFIC", RollingFileAppender) {
  file = "${loghome}/traffic"
  layout(PatternLayout) {
	pattern = "%message%n"
  }
  rollingPolicy(TrafficTimeBasedRollingPolicy) {
	fileNamePattern = "${loghome}/traffic.%d{yyyyMM}"
  }
}
appender("REQUEST", RollingFileAppender) {
  file = "${loghome}/request.log"
  layout(PatternLayout) {
	pattern = "%message%n"
  }
  rollingPolicy(FixedWindowRollingPolicy) {
	fileNamePattern = "${loghome}/request.%i.log"
	maxIndex = 13
  }
  triggeringPolicy(SizeBasedTriggeringPolicy) {
	maxFileSize = "10MB"
  }
}
root(WARN, ["CONSOLE", "FILE"])
logger("com.liulangf", INFO, ["CONSOLE", "FILE"], false)
/*
logger("org.artifactory", INFO)
logger("org.artifactory.repo.index", ERROR)
logger("org.artifactory.info.InfoWriter", WARN)
logger("org.artifactory.security.AccessLogger", INFO, ["ACCESS"], false)
logger("org.artifactory.api.common.StatusHolder", DEBUG, ["IMPORT.EXPORT"], false)
logger("org.artifactory.traffic.TrafficLogger", INFO, ["TRAFFIC"], false)
logger("org.artifactory.traffic.RequestLogger", INFO, ["REQUEST"], false)
logger("org.apache.wicket", ERROR)
logger("org.apache.jasper", INFO)
logger("httpclient.wire", INFO)
logger("org.apache.jackrabbit", WARN)
logger("org.eclipse.jetty", INFO)
logger("org.apache.commons.httpclient", INFO)
logger("org.springframework", WARN) 
*/
