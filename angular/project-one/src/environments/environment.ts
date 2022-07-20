// This file can be replaced during build by using the `fileReplacements` array.
// `ng build` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

export const environment = {
  production: false,
  generalUrl: 'http://localhost:8080/projectone/warehouses/general/',
  warehouseUrl: 'http://localhost:8080/projectone/warehouses/warehouses/',
  nameUrl: 'http://localhost:8080/projectone/warehouses/name/',
  priceUrl: 'http://localhost:8080/projectone/warehouses/price/',
  deleteUrl: 'http://localhost:8080/projectone/warehouses/delete'
};

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/plugins/zone-error';  // Included with Angular CLI.
