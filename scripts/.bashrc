# .bashrc

# Source global definitions
if [ -f /etc/bashrc ]; then
	. /etc/bashrc
fi

# User specific aliases and functions
export PS1="[\t][\u@\h:\w]\$ "
set -o vi

# Java
#
export JAVA_HOME=~/bala/util/java
export PATH=${JAVA_HOME}/bin:${PATH}

# IntelliJ
#
export IDEA_HOME=~/bala/util/idea
export PATH=${PATH}:${IDEA_HOME}/bin

# Eclipse
#
export ECLIPSE_HOME=~/bala/util/eclipse
export PATH=${PATH}:${ECLIPSE_HOME}

# Jetty
#
export JETTY_HOME=~/bala/util/jetty
export PATH=${PATH}:${JETTY_HOME}/bin

# Gradle
#
export GRADLE_HOME=~/bala/util/gradle
export PATH=${PATH}:${GRADLE_HOME}/bin

# Gradle
#
export MAVEN_HOME=~/bala/util/maven
export PATH=${PATH}:${MAVEN_HOME}/bin
export M2_HOME=${MAVEN_HOME}

# git
#
export GIT_HOME=~/bala/util/git
export PATH=${GIT_HOME}/bin:${PATH}
