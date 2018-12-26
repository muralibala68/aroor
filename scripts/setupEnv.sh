#!/bin/bash
#
# setupEnv.sh for windows
# author: murali
# date  : 26th-Dec-2018

# Source global definitions
[[ -f /etc/bash.bashrc ]] && . /etc/bash.bashrc

# User specific aliases and functions
set -o vi

# git
#
export GIT_HOME=/c/Program\ Files/Git
export PATH=${GIT_HOME}/bin:${PATH}

# Java
#
export JAVA_HOME=/c/Program\ Files/java/jdk1.8.0_162
export PATH=${JAVA_HOME}/bin:${PATH}
#export JAVA_OPTS="...HTTP proxy"

# Local installation home, amend suitably
#
export UTIL_HOME=/c/users/murali/util

# Gradle
#
export GRADLE_HOME=${UTIL_HOME}/gradle-4.5.1
export PATH=${PATH}:${GRADLE_HOME}/bin
export GRADLE_USER_HOME=${UTIL_HOME}/.gradle
export GRADLE_OPTS="-Dgradle.user.home=${GRADLE_USER_HOME}"

# Maven
#
export MAVEN_HOME=${UTIL_HOME}/apache-maven-3.6.0
export MAVEN_REPO=${UTIL_HOME}/.m2/repo
export MAVEN_OPTS="-Xms1024m -Xmx1024m -XX:PermSize=512m -XX:MaxPermSize=512m -Duser.home=${UTIL_HOME}"
export M2_HOME=${MAVEN_HOME}
export M2_REPO=${MAVEN_REPO}
export PATH=${PATH}:${MAVEN_HOME}/bin

#
# End
