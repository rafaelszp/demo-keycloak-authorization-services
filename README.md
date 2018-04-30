# Keycloak Authorization Services Demo

This project was intended to work with Keycloak Authorization Services using Policy enforcer. 

See [Authorization Services Guide](https://www.keycloak.org/docs/latest/authorization_services/index.html)

## Keycloak setup

1. Create application importing [demo.json](demo.json)
1. Create client roles for demo application(one for each resource)
    1. manager-role
    1. users-role
    1. companies-role
1. Inside authorization tab, import [demo-authz-config.json](demo-authz-config.json)
1. Create realm role
    1. demo-users
1. Create users regarding the role above
    1. demo-admin
    1. demo-user
    1. demo-company
1. Update users with the client permissions from demo application imported

## Application Testing

1. From IDE execute application `org.wildfly.swarm.Swarm` or
1. Maven:
    ```
    mvn wildfly-swarm:run
    ```
## TODO
1. Setup companies resources, policies and permissions
1. Setup manager resources, policies and permissions
