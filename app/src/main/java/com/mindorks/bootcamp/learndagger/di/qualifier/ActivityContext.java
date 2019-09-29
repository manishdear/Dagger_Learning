package com.mindorks.bootcamp.learndagger.di.qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

@ActivityContext
@Retention(RetentionPolicy.SOURCE)
public @interface ActivityContext {
}
