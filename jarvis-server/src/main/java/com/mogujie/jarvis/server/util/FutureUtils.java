/*
 * 蘑菇街 Inc.
 * Copyright (c) 2010-2015 All Rights Reserved.
 *
 * Author: wuya
 * Create Date: 2015年9月22日 下午2:22:35
 */

package com.mogujie.jarvis.server.util;

import java.util.concurrent.TimeUnit;

import akka.actor.ActorRef;
import akka.actor.ActorSelection;
import akka.pattern.Patterns;
import akka.util.Timeout;
import scala.concurrent.Await;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;

public class FutureUtils {

    public static Object awaitResult(ActorRef ref, Object msg, long seconds) throws Exception {
        Timeout timeout = new Timeout(Duration.create(seconds, TimeUnit.SECONDS));
        Future<Object> future = Patterns.ask(ref, msg, timeout);
        return Await.result(future, timeout.duration());
    }

    public static Object awaitResult(ActorSelection selection, Object msg, long seconds) throws Exception {
        Timeout timeout = new Timeout(Duration.create(seconds, TimeUnit.SECONDS));
        Future<Object> future = Patterns.ask(selection, msg, timeout);
        return Await.result(future, timeout.duration());
    }
}
