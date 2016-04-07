var AWS = {
  "util": {},
  "VERSION": {},
  "Signers": {},
  "Protocol": {},
  "XML": {},
  "JSON": {},
  "Model": {},
  "apiLoader": {
    "services": {}
  },
  "Service": {
    "__super__": function () {},
    "defineMethods": function () {},
    "defineService": function () {},
    "addVersions": function () {},
    "defineServiceApi": function () {},
    "hasService": function () {},
    "_serviceMap": {}
  },
  "Credentials": {
    "__super__": function () {}
  },
  "CredentialProviderChain": {
    "__super__": {
      "__super__": function () {}
    },
    "defaultProviders": {}
  },
  "TemporaryCredentials": {
    "__super__": {
      "__super__": function () {}
    }
  },
  "WebIdentityCredentials": {
    "__super__": {
      "__super__": function () {}
    }
  },
  "CognitoIdentityCredentials": {
    "__super__": {
      "__super__": function () {}
    }
  },
  "SAMLCredentials": {
    "__super__": {
      "__super__": function () {}
    }
  },
  "Config": {
    "__super__": function () {}
  },
  "config": {},
  "Endpoint": {
    "__super__": function () {}
  },
  "HttpRequest": {
    "__super__": function () {}
  },
  "HttpResponse": {
    "__super__": function () {}
  },
  "HttpClient": {
    "__super__": function () {},
    "getInstance": function () {},
    "streamsApiVersion": {}
  },
  "SequentialExecutor": {
    "__super__": function () {}
  },
  "EventListeners": {},
  "Request": {
    "__super__": function () {}
  },
  "Response": {
    "__super__": function () {}
  },
  "ResourceWaiter": {
    "__super__": function () {}
  },
  "ParamValidator": {
    "__super__": function () {}
  },
  "events": {},
  "XHRClient": {
    "__super__": function () {}
  },
  "CognitoIdentity": {
    "__super__": {
      "__super__": function () {},
      "defineMethods": function () {},
      "defineService": function () {},
      "addVersions": function () {},
      "defineServiceApi": function () {},
      "hasService": function () {},
      "_serviceMap": {}
    },
    "services": {},
    "apiVersions": {},
    "serviceIdentifier": {}
  },
  "CognitoSync": {
    "__super__": {
      "__super__": function () {},
      "defineMethods": function () {},
      "defineService": function () {},
      "addVersions": function () {},
      "defineServiceApi": function () {},
      "hasService": function () {},
      "_serviceMap": {}
    },
    "services": {},
    "apiVersions": {},
    "serviceIdentifier": {}
  },
  "ConfigService": {
    "__super__": {
      "__super__": function () {},
      "defineMethods": function () {},
      "defineService": function () {},
      "addVersions": function () {},
      "defineServiceApi": function () {},
      "hasService": function () {},
      "_serviceMap": {}
    },
    "services": {},
    "apiVersions": {},
    "serviceIdentifier": {}
  },
  "Lambda": {
    "__super__": {
      "__super__": function () {},
      "defineMethods": function () {},
      "defineService": function () {},
      "addVersions": function () {},
      "defineServiceApi": function () {},
      "hasService": function () {},
      "_serviceMap": {}
    },
    "services": {},
    "apiVersions": {},
    "serviceIdentifier": {}
  },
  "STS": {
    "__super__": {
      "__super__": function () {},
      "defineMethods": function () {},
      "defineService": function () {},
      "addVersions": function () {},
      "defineServiceApi": function () {},
      "hasService": function () {},
      "_serviceMap": {}
    },
    "services": {},
    "apiVersions": {},
    "serviceIdentifier": {}
  },
  "CognitoSyncManager": {
    "Conflict": function () {},
    "Dataset": function () {},
    "DatasetMetadata": function () {},
    "DatasetUpdates": function () {},
    "LocalStorage": function () {},
    "Record": function () {},
    "RemoteStorage": function () {},
    "StoreInMemory": function () {},
    "StoreLocalStorage": function () {}
  }
};
AWS.Service.prototype = {
  "constructor": function () {},
  "initialize": function () {},
  "validateService": function () {},
  "loadServiceClass": function () {},
  "getLatestServiceClass": function () {},
  "getLatestServiceVersion": function () {},
  "api": function () {},
  "defaultRetryCount": function () {},
  "makeRequest": function () {},
  "makeUnauthenticatedRequest": function () {},
  "waitFor": function () {},
  "addAllRequestListeners": function () {},
  "setupRequestListeners": function () {},
  "getSignerClass": function () {},
  "serviceInterface": function () {},
  "successfulResponse": function () {},
  "numRetries": function () {},
  "retryDelays": function () {},
  "retryableError": function () {},
  "networkingError": function () {},
  "expiredCredentialsError": function () {},
  "clockSkewError": function () {},
  "throttledError": function () {},
  "endpointFromTemplate": function () {},
  "setEndpoint": function () {},
  "paginationConfig": function () {}
};
AWS.Credentials.prototype = {
  "constructor": function () {},
  "expiryWindow": function () {},
  "needsRefresh": function () {},
  "get": function () {},
  "refresh": function () {}
};
AWS.CredentialProviderChain.prototype = {
  "constructor": function () {},
  "resolve": function () {},
  "expiryWindow": function () {},
  "needsRefresh": function () {},
  "get": function () {},
  "refresh": function () {}
};
AWS.CredentialProviderChain.__super__.prototype = {
  "constructor": function () {},
  "expiryWindow": function () {},
  "needsRefresh": function () {},
  "get": function () {},
  "refresh": function () {}
};
AWS.TemporaryCredentials.prototype = {
  "constructor": function () {},
  "refresh": function () {},
  "loadMasterCredentials": function () {},
  "createClients": function () {},
  "expiryWindow": function () {},
  "needsRefresh": function () {},
  "get": function () {}
};
AWS.TemporaryCredentials.__super__.prototype = {
  "constructor": function () {},
  "expiryWindow": function () {},
  "needsRefresh": function () {},
  "get": function () {},
  "refresh": function () {}
};
AWS.WebIdentityCredentials.prototype = {
  "constructor": function () {},
  "refresh": function () {},
  "createClients": function () {},
  "expiryWindow": function () {},
  "needsRefresh": function () {},
  "get": function () {}
};
AWS.WebIdentityCredentials.__super__.prototype = {
  "constructor": function () {},
  "expiryWindow": function () {},
  "needsRefresh": function () {},
  "get": function () {},
  "refresh": function () {}
};
AWS.CognitoIdentityCredentials.prototype = {
  "localStorageKey": function () {},
  "constructor": function () {},
  "refresh": function () {},
  "clearCachedId": function () {},
  "getId": function () {},
  "loadCredentials": function () {},
  "getCredentialsForIdentity": function () {},
  "getCredentialsFromSTS": function () {},
  "loadCachedId": function () {},
  "createClients": function () {},
  "cacheId": function () {},
  "getStorage": function () {},
  "setStorage": function () {},
  "storage": function () {},
  "expiryWindow": function () {},
  "needsRefresh": function () {},
  "get": function () {}
};
AWS.CognitoIdentityCredentials.__super__.prototype = {
  "constructor": function () {},
  "expiryWindow": function () {},
  "needsRefresh": function () {},
  "get": function () {},
  "refresh": function () {}
};
AWS.SAMLCredentials.prototype = {
  "constructor": function () {},
  "refresh": function () {},
  "createClients": function () {},
  "expiryWindow": function () {},
  "needsRefresh": function () {},
  "get": function () {}
};
AWS.SAMLCredentials.__super__.prototype = {
  "constructor": function () {},
  "expiryWindow": function () {},
  "needsRefresh": function () {},
  "get": function () {},
  "refresh": function () {}
};
AWS.Config.prototype = {
  "constructor": function () {},
  "getCredentials": function () {},
  "update": function () {},
  "loadFromPath": function () {},
  "clear": function () {},
  "set": function () {},
  "keys": function () {},
  "extractCredentials": function () {},
  "setPromisesDependency": function () {}
};
AWS.Endpoint.prototype = {
  "constructor": function () {}
};
AWS.HttpRequest.prototype = {
  "constructor": function () {},
  "setUserAgent": function () {},
  "pathname": function () {},
  "search": function () {}
};
AWS.HttpResponse.prototype = {
  "constructor": function () {},
  "createUnbufferedStream": function () {}
};
AWS.HttpClient.prototype = {
  "handleRequest": function () {},
  "parseHeaders": function () {},
  "finishRequest": function () {},
  "constructor": function () {}
};
AWS.SequentialExecutor.prototype = {
  "constructor": function () {},
  "listeners": function () {},
  "on": function () {},
  "onAsync": function () {},
  "removeListener": function () {},
  "removeAllListeners": function () {},
  "emit": function () {},
  "callListeners": function () {},
  "addListeners": function () {},
  "addNamedListener": function () {},
  "addNamedAsyncListener": function () {},
  "addNamedListeners": function () {},
  "addListener": function () {}
};
AWS.Request.prototype = {
  "constructor": function () {},
  "send": function () {},
  "build": function () {},
  "runTo": function () {},
  "abort": function () {},
  "eachPage": function () {},
  "eachItem": function () {},
  "isPageable": function () {},
  "createReadStream": function () {},
  "emitEvent": function () {},
  "eventParameters": function () {},
  "presign": function () {},
  "toUnauthenticated": function () {},
  "toGet": function () {},
  "buildAsGet": function () {},
  "haltHandlersOnError": function () {},
  "promise": function () {},
  "listeners": function () {},
  "on": function () {},
  "onAsync": function () {},
  "removeListener": function () {},
  "removeAllListeners": function () {},
  "emit": function () {},
  "callListeners": function () {},
  "addListeners": function () {},
  "addNamedListener": function () {},
  "addNamedAsyncListener": function () {},
  "addNamedListeners": function () {},
  "addListener": function () {}
};
AWS.Response.prototype = {
  "constructor": function () {},
  "nextPage": function () {},
  "hasNextPage": function () {},
  "cacheNextPageTokens": function () {}
};
AWS.ResourceWaiter.prototype = {
  "constructor": function () {},
  "service": function () {},
  "state": function () {},
  "config": function () {},
  "matchers": function () {},
  "listeners": function () {},
  "wait": function () {},
  "setSuccess": function () {},
  "setError": function () {},
  "loadWaiterConfig": function () {}
};
AWS.ParamValidator.prototype = {
  "constructor": function () {},
  "validate": function () {},
  "fail": function () {},
  "validateStructure": function () {},
  "validateMember": function () {},
  "validateList": function () {},
  "validateMap": function () {},
  "validateScalar": function () {},
  "validateString": function () {},
  "validatePattern": function () {},
  "validateRange": function () {},
  "validateEnum": function () {},
  "validateType": function () {},
  "validateNumber": function () {},
  "validatePayload": function () {}
};
AWS.XHRClient.prototype = {
  "handleRequest": function () {},
  "parseHeaders": function () {},
  "finishRequest": function () {},
  "constructor": function () {}
};
AWS.CognitoIdentity.prototype = {
  "constructor": function () {},
  "getOpenIdToken": function () {},
  "getId": function () {},
  "getCredentialsForIdentity": function () {},
  "initialize": function () {},
  "validateService": function () {},
  "loadServiceClass": function () {},
  "getLatestServiceClass": function () {},
  "getLatestServiceVersion": function () {},
  "api": function () {},
  "defaultRetryCount": function () {},
  "makeRequest": function () {},
  "makeUnauthenticatedRequest": function () {},
  "waitFor": function () {},
  "addAllRequestListeners": function () {},
  "setupRequestListeners": function () {},
  "getSignerClass": function () {},
  "serviceInterface": function () {},
  "successfulResponse": function () {},
  "numRetries": function () {},
  "retryDelays": function () {},
  "retryableError": function () {},
  "networkingError": function () {},
  "expiredCredentialsError": function () {},
  "clockSkewError": function () {},
  "throttledError": function () {},
  "endpointFromTemplate": function () {},
  "setEndpoint": function () {},
  "paginationConfig": function () {}
};
AWS.CognitoIdentity.__super__.prototype = {
  "constructor": function () {},
  "initialize": function () {},
  "validateService": function () {},
  "loadServiceClass": function () {},
  "getLatestServiceClass": function () {},
  "getLatestServiceVersion": function () {},
  "api": function () {},
  "defaultRetryCount": function () {},
  "makeRequest": function () {},
  "makeUnauthenticatedRequest": function () {},
  "waitFor": function () {},
  "addAllRequestListeners": function () {},
  "setupRequestListeners": function () {},
  "getSignerClass": function () {},
  "serviceInterface": function () {},
  "successfulResponse": function () {},
  "numRetries": function () {},
  "retryDelays": function () {},
  "retryableError": function () {},
  "networkingError": function () {},
  "expiredCredentialsError": function () {},
  "clockSkewError": function () {},
  "throttledError": function () {},
  "endpointFromTemplate": function () {},
  "setEndpoint": function () {},
  "paginationConfig": function () {}
};
AWS.CognitoSync.prototype = {
  "constructor": function () {},
  "initialize": function () {},
  "validateService": function () {},
  "loadServiceClass": function () {},
  "getLatestServiceClass": function () {},
  "getLatestServiceVersion": function () {},
  "api": function () {},
  "defaultRetryCount": function () {},
  "makeRequest": function () {},
  "makeUnauthenticatedRequest": function () {},
  "waitFor": function () {},
  "addAllRequestListeners": function () {},
  "setupRequestListeners": function () {},
  "getSignerClass": function () {},
  "serviceInterface": function () {},
  "successfulResponse": function () {},
  "numRetries": function () {},
  "retryDelays": function () {},
  "retryableError": function () {},
  "networkingError": function () {},
  "expiredCredentialsError": function () {},
  "clockSkewError": function () {},
  "throttledError": function () {},
  "endpointFromTemplate": function () {},
  "setEndpoint": function () {},
  "paginationConfig": function () {}
};
AWS.CognitoSync.__super__.prototype = {
  "constructor": function () {},
  "initialize": function () {},
  "validateService": function () {},
  "loadServiceClass": function () {},
  "getLatestServiceClass": function () {},
  "getLatestServiceVersion": function () {},
  "api": function () {},
  "defaultRetryCount": function () {},
  "makeRequest": function () {},
  "makeUnauthenticatedRequest": function () {},
  "waitFor": function () {},
  "addAllRequestListeners": function () {},
  "setupRequestListeners": function () {},
  "getSignerClass": function () {},
  "serviceInterface": function () {},
  "successfulResponse": function () {},
  "numRetries": function () {},
  "retryDelays": function () {},
  "retryableError": function () {},
  "networkingError": function () {},
  "expiredCredentialsError": function () {},
  "clockSkewError": function () {},
  "throttledError": function () {},
  "endpointFromTemplate": function () {},
  "setEndpoint": function () {},
  "paginationConfig": function () {}
};
AWS.ConfigService.prototype = {
  "constructor": function () {},
  "initialize": function () {},
  "validateService": function () {},
  "loadServiceClass": function () {},
  "getLatestServiceClass": function () {},
  "getLatestServiceVersion": function () {},
  "api": function () {},
  "defaultRetryCount": function () {},
  "makeRequest": function () {},
  "makeUnauthenticatedRequest": function () {},
  "waitFor": function () {},
  "addAllRequestListeners": function () {},
  "setupRequestListeners": function () {},
  "getSignerClass": function () {},
  "serviceInterface": function () {},
  "successfulResponse": function () {},
  "numRetries": function () {},
  "retryDelays": function () {},
  "retryableError": function () {},
  "networkingError": function () {},
  "expiredCredentialsError": function () {},
  "clockSkewError": function () {},
  "throttledError": function () {},
  "endpointFromTemplate": function () {},
  "setEndpoint": function () {},
  "paginationConfig": function () {}
};
AWS.ConfigService.__super__.prototype = {
  "constructor": function () {},
  "initialize": function () {},
  "validateService": function () {},
  "loadServiceClass": function () {},
  "getLatestServiceClass": function () {},
  "getLatestServiceVersion": function () {},
  "api": function () {},
  "defaultRetryCount": function () {},
  "makeRequest": function () {},
  "makeUnauthenticatedRequest": function () {},
  "waitFor": function () {},
  "addAllRequestListeners": function () {},
  "setupRequestListeners": function () {},
  "getSignerClass": function () {},
  "serviceInterface": function () {},
  "successfulResponse": function () {},
  "numRetries": function () {},
  "retryDelays": function () {},
  "retryableError": function () {},
  "networkingError": function () {},
  "expiredCredentialsError": function () {},
  "clockSkewError": function () {},
  "throttledError": function () {},
  "endpointFromTemplate": function () {},
  "setEndpoint": function () {},
  "paginationConfig": function () {}
};
AWS.Lambda.prototype = {
  "constructor": function () {},
  "initialize": function () {},
  "validateService": function () {},
  "loadServiceClass": function () {},
  "getLatestServiceClass": function () {},
  "getLatestServiceVersion": function () {},
  "api": function () {},
  "defaultRetryCount": function () {},
  "makeRequest": function () {},
  "makeUnauthenticatedRequest": function () {},
  "waitFor": function () {},
  "addAllRequestListeners": function () {},
  "setupRequestListeners": function () {},
  "getSignerClass": function () {},
  "serviceInterface": function () {},
  "successfulResponse": function () {},
  "numRetries": function () {},
  "retryDelays": function () {},
  "retryableError": function () {},
  "networkingError": function () {},
  "expiredCredentialsError": function () {},
  "clockSkewError": function () {},
  "throttledError": function () {},
  "endpointFromTemplate": function () {},
  "setEndpoint": function () {},
  "paginationConfig": function () {}
};
AWS.Lambda.__super__.prototype = {
  "constructor": function () {},
  "initialize": function () {},
  "validateService": function () {},
  "loadServiceClass": function () {},
  "getLatestServiceClass": function () {},
  "getLatestServiceVersion": function () {},
  "api": function () {},
  "defaultRetryCount": function () {},
  "makeRequest": function () {},
  "makeUnauthenticatedRequest": function () {},
  "waitFor": function () {},
  "addAllRequestListeners": function () {},
  "setupRequestListeners": function () {},
  "getSignerClass": function () {},
  "serviceInterface": function () {},
  "successfulResponse": function () {},
  "numRetries": function () {},
  "retryDelays": function () {},
  "retryableError": function () {},
  "networkingError": function () {},
  "expiredCredentialsError": function () {},
  "clockSkewError": function () {},
  "throttledError": function () {},
  "endpointFromTemplate": function () {},
  "setEndpoint": function () {},
  "paginationConfig": function () {}
};
AWS.STS.prototype = {
  "constructor": function () {},
  "credentialsFrom": function () {},
  "assumeRoleWithWebIdentity": function () {},
  "assumeRoleWithSAML": function () {},
  "initialize": function () {},
  "validateService": function () {},
  "loadServiceClass": function () {},
  "getLatestServiceClass": function () {},
  "getLatestServiceVersion": function () {},
  "api": function () {},
  "defaultRetryCount": function () {},
  "makeRequest": function () {},
  "makeUnauthenticatedRequest": function () {},
  "waitFor": function () {},
  "addAllRequestListeners": function () {},
  "setupRequestListeners": function () {},
  "getSignerClass": function () {},
  "serviceInterface": function () {},
  "successfulResponse": function () {},
  "numRetries": function () {},
  "retryDelays": function () {},
  "retryableError": function () {},
  "networkingError": function () {},
  "expiredCredentialsError": function () {},
  "clockSkewError": function () {},
  "throttledError": function () {},
  "endpointFromTemplate": function () {},
  "setEndpoint": function () {},
  "paginationConfig": function () {}
};
AWS.STS.__super__.prototype = {
  "constructor": function () {},
  "initialize": function () {},
  "validateService": function () {},
  "loadServiceClass": function () {},
  "getLatestServiceClass": function () {},
  "getLatestServiceVersion": function () {},
  "api": function () {},
  "defaultRetryCount": function () {},
  "makeRequest": function () {},
  "makeUnauthenticatedRequest": function () {},
  "waitFor": function () {},
  "addAllRequestListeners": function () {},
  "setupRequestListeners": function () {},
  "getSignerClass": function () {},
  "serviceInterface": function () {},
  "successfulResponse": function () {},
  "numRetries": function () {},
  "retryDelays": function () {},
  "retryableError": function () {},
  "networkingError": function () {},
  "expiredCredentialsError": function () {},
  "clockSkewError": function () {},
  "throttledError": function () {},
  "endpointFromTemplate": function () {},
  "setEndpoint": function () {},
  "paginationConfig": function () {}
};
AWS.CognitoSyncManager.prototype = {
  "openOrCreateDataset": function () {},
  "listDatasets": function () {},
  "refreshDatasetMetadata": function () {},
  "wipeData": function () {},
  "getIdentityId": function () {}
};
AWS.CognitoSyncManager.Conflict.prototype = {
  "getKey": function () {},
  "getRemoteRecord": function () {},
  "getLocalRecord": function () {},
  "resolveWithRemoteRecord": function () {},
  "resolveWithLocalRecord": function () {},
  "resolveWithValue": function () {}
};
AWS.CognitoSyncManager.Dataset.prototype = {
  "validateKey": function () {},
  "put": function () {},
  "remove": function () {},
  "get": function () {},
  "getAllRecords": function () {},
  "getDataStorage": function () {},
  "isChanged": function () {},
  "getDatasetMetadata": function () {},
  "resolve": function () {},
  "putAll": function () {},
  "getAll": function () {},
  "getIdentityId": function () {},
  "getModifiedRecords": function () {},
  "getLocalMergedDatasets": function () {},
  "synchronize": function () {},
  "_synchronizeResolveLocal": function () {},
  "_synchronizePushRemote": function () {}
};
AWS.CognitoSyncManager.DatasetMetadata.prototype = {
  "getDatasetName": function () {},
  "setDatasetName": function () {},
  "getCreationDate": function () {},
  "setCreationDate": function () {},
  "getLastModifiedDate": function () {},
  "setLastModifiedDate": function () {},
  "getLastModifiedBy": function () {},
  "setLastModifiedBy": function () {},
  "getDataStorage": function () {},
  "setDataStorage": function () {},
  "getRecordCount": function () {},
  "setRecordCount": function () {},
  "getLastSyncCount": function () {},
  "setLastSyncCount": function () {},
  "getLastSyncDate": function () {},
  "setLastSyncDate": function () {},
  "toString": function () {},
  "toJSON": function () {}
};
AWS.CognitoSyncManager.DatasetUpdates.prototype = {
  "getDatasetName": function () {},
  "setDatasetName": function () {},
  "getRecords": function () {},
  "addRecord": function () {},
  "getSyncCount": function () {},
  "setSyncCount": function () {},
  "getSyncSessionToken": function () {},
  "setSyncSessionToken": function () {},
  "isExists": function () {},
  "setExists": function () {},
  "isDeleted": function () {},
  "setDeleted": function () {},
  "getMergedDatasetNameList": function () {},
  "setMergedDatasetNameList": function () {}
};
AWS.CognitoSyncManager.LocalStorage.prototype = {
  "getMetadataKey": function () {},
  "loadMetadataCache": function () {},
  "saveMetadataCache": function () {},
  "createDataset": function () {},
  "getDatasetMetadata": function () {},
  "setDatasetMetadata": function () {},
  "getValue": function () {},
  "putValue": function () {},
  "getValueMap": function () {},
  "putAllValues": function () {},
  "getDatasets": function () {},
  "updateDatasetMetadata": function () {},
  "getRecord": function () {},
  "getRecords": function () {},
  "putRecords": function () {},
  "deleteDataset": function () {},
  "purgeDataset": function () {},
  "getLastSyncCount": function () {},
  "getModifiedRecords": function () {},
  "updateLastSyncCount": function () {},
  "wipeData": function () {},
  "updateLastModifiedTimestamp": function () {},
  "removeRecord": function () {},
  "updateAndClearRecord": function () {}
};
AWS.CognitoSyncManager.Record.prototype = {
  "getKey": function () {},
  "setKey": function () {},
  "getValue": function () {},
  "setValue": function () {},
  "getSyncCount": function () {},
  "setSyncCount": function () {},
  "getLastModifiedDate": function () {},
  "setLastModifiedDate": function () {},
  "getLastModifiedBy": function () {},
  "setLastModifiedBy": function () {},
  "getDeviceLastModifiedDate": function () {},
  "setDeviceLastModifiedDate": function () {},
  "isModified": function () {},
  "setModified": function () {},
  "isDeleted": function () {},
  "toString": function () {},
  "toJSON": function () {}
};
AWS.CognitoSyncManager.RemoteStorage.prototype = {
  "userAgent": function () {},
  "getIdentityId": function () {},
  "getDatasets": function () {},
  "listUpdates": function () {},
  "putRecords": function () {},
  "deleteDataset": function () {},
  "getDatasetMetadata": function () {},
  "setUserAgent": function () {}
};
AWS.CognitoSyncManager.StoreInMemory.prototype = {
  "makeKey": function () {},
  "get": function () {},
  "getAll": function () {},
  "set": function () {},
  "setAll": function () {},
  "remove": function () {},
  "removeAll": function () {},
  "wipe": function () {}
};
AWS.CognitoSyncManager.StoreLocalStorage.prototype = {
  "makeKey": function () {},
  "get": function () {},
  "getAll": function () {},
  "set": function () {},
  "setAll": function () {},
  "remove": function () {},
  "removeAll": function () {},
  "wipe": function () {}
};
