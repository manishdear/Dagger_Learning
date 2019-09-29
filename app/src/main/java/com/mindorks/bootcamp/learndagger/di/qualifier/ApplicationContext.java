package com.mindorks.bootcamp.learndagger.di.qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

@ApplicationContext
@Retention(RetentionPolicy.SOURCE)
public @interface ApplicationContext {
}
