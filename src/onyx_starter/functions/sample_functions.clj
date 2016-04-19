(ns onyx-starter.functions.sample-functions
  (:require [clojure.string :refer [trim capitalize]]))

;;; Defines functions to be used by the peers. These are located
;;; with fully qualified namespaced keywords, such as
;;; onyx-starter.functions.sample-functions/format-line

(defn add
  [segment]
  (update segment :value inc))

(defn mult 
  [segment]
  (update segment :value (partial * 10)))

(defn add-bang
  [segment]
  (update segment :value (partial str "!")))

(defn enough?
  [event {:keys [value]} _ _]
  (if (> value 100)
    true
    false))

(defn never
  [event {:keys [value]} _ _]
  false)
(defn always
  [event {:keys [value]} _ _]
  true)
