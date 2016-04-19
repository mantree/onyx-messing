(ns onyx-starter.jobs.sample-job-test
  (:require [clojure.test :refer [deftest is]]
            [com.stuartsierra.component :as component]
            [onyx-starter.launcher.submit-sample-job :as submit-sample]
            [onyx-starter.launcher.dev-system :refer [onyx-dev-env]]
            [onyx-starter.functions.sample-functions]
            [onyx-starter.flow-conditions.sample-flow-conditions]
            [onyx.api]))

(deftest test-sample-dev-job
  ;; 8 peers for 8 distinct tasks in the workflow
  (let [dev-env (component/start (onyx-dev-env 8))]
    (try 
      (let [{:keys [out-chan]} (submit-sample/submit-job dev-env)]
        (clojure.pprint/pprint out-chan)
        (println)
        (is (= 12 (count out-chan))))
      (finally 
        (component/stop dev-env)))))
