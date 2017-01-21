#!/bin/bash

# exports PATHs
source app.env

function init() {
  rm -r ${CATALINA_BASE}
  mkdir -p ${CATALINA_BASE}
  mkdir -p ${CATALINA_BASE}/conf
  mkdir -p ${CATALINA_BASE}/logs
  mkdir -p ${CATALINA_BASE}/webapps
  mkdir -p ${CATALINA_BASE}/temp
  mkdir -p ${CATALINA_BASE}/work

  ### copy server config files
  cp ${CATALINA_HOME}/conf/server.xml ${CATALINA_BASE}/conf
  cp ${CATALINA_HOME}/conf/web.xml ${CATALINA_BASE}/conf

  ### copy custom scripts
  cp ./app.env ${CATALINA_BASE}/
  cp ./halt.sh ${CATALINA_BASE}/
  cp ./start.sh ${CATALINA_BASE}/
  cp ./restart.sh ${CATALINA_BASE}/
}

function deploy() {
  ${CATALINA_BASE}/halt.sh
  cp ../target/${APP_NAME}.war ${CATALINA_BASE}/webapps/ROOT.war
  ${CATALINA_BASE}/start.sh
  echo "${APP_NAME} was deployed to ${CATALINA_BASE}/webapps/ROOT.war"
}

if [ "$1" == "init" ]; then
  init
fi

deploy
exit 0;
