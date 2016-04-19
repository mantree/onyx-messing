(ns onyx-starter.workflows.sample-workflow)

;;; The workflow of an Onyx job describes the graph of all possible
;;; tasks that data can flow between.

(def looped-flow
  [[:in :add]
   [:add :mult]
   [:mult :add-bang]
   [:mult :in-again]
   [:add-bang :out-chan]])

(def looped-redis-flow
  [[:in :add]
   [:in-redis :add]
   [:add :mult]
   [:mult :add-bang]
   [:mult :prep-redis]
   [:prep-redis :out-redis]
   [:add-bang :out-chan]])
