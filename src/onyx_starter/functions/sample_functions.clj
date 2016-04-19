(ns onyx-starter.functions.sample-functions
  (:require [clojure.string :refer [trim capitalize]]))

;;; Defines functions to be used by the peers. These are located
;;; with fully qualified namespaced keywords, such as
;;; onyx-starter.functions.sample-functions/format-line

(defn split-by-spaces-impl [s]
  (clojure.string/split s #"\s+"))

(defn mixed-case-impl [s]
  (->> (cycle [(memfn toUpperCase) (memfn toLowerCase)])
       (map #(%2 (str %1)) s)
       (apply str)))

(defn loud-impl [s]
  (str s "!"))

(defn question-impl [s]
  (str s "?"))

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

;;;;; Destructuring functions ;;;;;
(defn split-by-spaces [segment]
  (map (fn [word] {:word word}) (split-by-spaces-impl (:sentence segment))))

(defn mixed-case [segment]
  {:word (mixed-case-impl (:word segment))})

(defn loud [segment]
  {:word (loud-impl (:word segment))})

(defn question [segment]
  {:word (question-impl (:word segment))})
