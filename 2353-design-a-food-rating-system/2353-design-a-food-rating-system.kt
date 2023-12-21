import java.util.SortedSet

class FoodRatings(
    foods: Array<String>,
    private val cuisines: Array<String>,
    private val ratings: IntArray,
) {
    private val foodIndices = foods.withIndex().associate { it.value to it.index }
    private val scoresByCuisine = mutableMapOf<String, SortedSet<Pair<Int, String>>>()

    init {
        for (i in foods.indices) {
            val food = foods[i]
            val cuisine = cuisines[i]
            val rating = ratings[i]

            val scores = scoresByCuisine.getOrPut(cuisine)
            { sortedSetOf(compareByDescending<Pair<Int, String>> { it.first }.thenBy { it.second }) }

            val pair = rating to food
            scores.add(pair)
        }
    }

    fun changeRating(food: String, newRating: Int) {
        val i = foodIndices[food]!!
        val cuisine = cuisines[i]
        val scores = scoresByCuisine[cuisine]!!

        val previous = ratings[i] to food
        scores.remove(previous)

        val new = newRating to food
        scores.add(new)
        ratings[i] = newRating
    }


    fun highestRated(cuisine: String): String {
        val scores = scoresByCuisine[cuisine]!!
        return scores.first().second
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * var obj = FoodRatings(foods, cuisines, ratings)
 * obj.changeRating(food,newRating)
 * var param_2 = obj.highestRated(cuisine)
 */