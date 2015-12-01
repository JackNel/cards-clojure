(ns cards-clojure.core-test
  (:require [clojure.test :refer :all]
            [cards-clojure.core :refer :all]))

(def hand-1 #{{:suit :clubs
               :rank 3}
              {:suit :clubs
               :rank 5}
              {:suit :clubs
               :rank 4}
              {:suit :clubs
               :rank 2}})

(def hand-2 #{{:suit :diamonds
               :rank 2}
              {:suit :clubs
               :rank 2}
              {:suit :clubs
               :rank 5}
              {:suit :clubs
               :rank 4}})

(deftest flush-test
  (testing "flush? returns true if the hand is a flush"
    (is (= true (flush? hand-1)))
    (is (= false (flush? hand-2)))))

(def hand-3 #{{:suit :spades
               :rank 3}
              {:suit :clubs
               :rank 5}
              {:suit :clubs
               :rank 4}
              {:suit :clubs
               :rank 2}})

(def hand-4 #{{:suit :diamonds
               :rank 2}
              {:suit :clubs
               :rank 2}
              {:suit :clubs
               :rank 5}
              {:suit :clubs
               :rank 4}})

(deftest straight-test
  (testing "straight? returns true if the hand is a straight"
  (is (= true (straight? hand-3)))
  (is (= false (straight? hand-4)))))

(def hand-5 #{{:suit :clubs
               :rank 3}
              {:suit :clubs
               :rank 5}
              {:suit :clubs
               :rank 4}
              {:suit :clubs
               :rank 2}})

(def hand-6 #{{:suit :diamonds
               :rank 2}
              {:suit :clubs
               :rank 2}
              {:suit :clubs
               :rank 5}
              {:suit :clubs
               :rank 4}})

(deftest straight-flush-test
  (testing "straight-flush? returns true if hand is a straight flush"
    (is (= true (straight-flush? hand-5)))
    (is (= false (straight-flush? hand-6)))))

(def hand-7 #{{:suit :clubs
               :rank 5}
              {:suit :spades
               :rank 5}
              {:suit :diamonds
               :rank 5}
              {:suit :hearts
               :rank 5}})

(def hand-8 #{{:suit :clubs
               :rank 2}
              {:suit :diamonds
               :rank 2}
              {:suit :spades
               :rank 2}
              {:suit :hearts
               :rank 4}})

(deftest four-of-a-kind-test
  (testing "four-of-a-kind? returns true if hand is a four of a kind"
    (is (= true (four-of-a-kind? hand-7)))
    (is (= false (four-of-a-kind? hand-8)))))