ARG APP_INSIGHTS_AGENT_VERSION=2.5.1

# Application image

FROM hmctspublic.azurecr.io/base/java:17-distroless

COPY lib/AI-Agent.xml /opt/app/
COPY build/libs/wa-post-deployment-ft-tests.jar /opt/app/

EXPOSE 8888
CMD [ "wa-post-deployment-ft-tests.jar" ]
