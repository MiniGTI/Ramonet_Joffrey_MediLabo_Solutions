export const Environment= {
  name: 'docker',
  keycloak: {
    issuer: 'http://localhost:8080',
    realm: 'Medilabo-Solutions-realm',
    clientId: 'angular_login',
    redirectUri: 'http://localhost:4200'

  }
}
