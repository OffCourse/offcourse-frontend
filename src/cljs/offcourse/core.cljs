(ns offcourse.core
  (:require [offcourse.system.index :refer [system]]
            [offcourse.adapters.pouchdb.index :as pouchdb]
            [offcourse.adapters.aws.index :as aws]
            [offcourse.adapters.fakedb.index :as fakedb]))

(defn app [bootstrap-docs auth-config cloud-config]
  (system "Offcourse_"
          [#_{:adapter           fakedb/new-db}
           {:adapter           aws/new-db
            :name              "aws"
            :endpoint          "https://6fp04c7v5e.execute-api.eu-west-1.amazonaws.com/staging/query"}]
          auth-config
          cloud-config))
