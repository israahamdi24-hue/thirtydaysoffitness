package com.example.thirtydaysoffitness

import androidx.annotation.DrawableRes

data class Day(
    val number: Int,
    val emoji: String,
    val title: String,
    val description: String,
    @DrawableRes val imageRes: Int? = null
)

val days = listOf(
    Day(1, "🚶", "Brisk 20-minute walk", "Lace up and walk at a pace that slightly raises your breathing. Keep your shoulders relaxed and swing your arms."),
    Day(2, "🏋️", "Bodyweight squats", "Do 3 sets of 12 squats. Keep your chest up, push your hips back and drive through your heels. Rest 45 seconds between sets."),
    Day(3, "💪", "Push-up basics", "Do 3 sets of 8 push-ups. Keep a straight line from head to heels. Drop to your knees if needed; form beats quantity."),
    Day(4, "🧱", "30-second plank", "Hold a forearm plank for 30 seconds, 3 times. Squeeze your glutes and keep your core tight."),
    Day(5, "🤸", "Mobility & stretching", "Spend 15 minutes on neck rolls, hip openers, hamstring and shoulder stretches. Never stretch into pain."),
    Day(6, "🪢", "Jump rope intervals", "Jump 30 seconds, rest 30 seconds, repeat for 10 rounds. No rope? Mimic the motion on your toes."),
    Day(7, "🧘", "Active rest: gentle yoga", "Flow through 20 minutes of easy yoga: cat-cow, child's pose and downward dog. Recovery is part of training."),
    Day(8, "🦵", "Walking lunges", "Take 3 sets of 10 steps per leg. Keep your front knee over your ankle and your torso upright."),
    Day(9, "🍑", "Glute bridges", "Lie on your back, feet flat, and lift your hips. Pause 2 seconds at the top. Do 3 sets of 15."),
    Day(10, "⛰️", "Mountain climbers", "In a high plank, drive your knees toward your chest. Do 4 rounds of 30 seconds with 30 seconds rest."),
    Day(11, "🚴", "Bicycle crunches", "Slowly bring opposite elbow to opposite knee. Do 3 sets of 20 reps without pulling on your neck."),
    Day(12, "🪑", "Chair tricep dips", "Use a sturdy chair. Lower until elbows reach 90 degrees, then press up. Do 3 sets of 10."),
    Day(13, "🔥", "Burpee challenge", "Do 5 rounds of 6 burpees. Move at your own pace and step back instead of jumping if needed."),
    Day(14, "💧", "Rest & hydrate", "Take a full rest day. Drink plenty of water, sleep 7–9 hours and enjoy an optional light stroll."),
    Day(15, "📊", "Halfway fitness check", "Time yourself doing as many squats and push-ups as you can in 1 minute each. Note the numbers and compare on day 30."),
    Day(16, "🪜", "Stair climbing", "Climb stairs for 15 minutes, one step at a time. Use the handrail for balance, not for pulling."),
    Day(17, "🧗", "Wall sit", "Slide down a wall until your thighs are parallel to the floor. Hold 45 seconds, 3 times."),
    Day(18, "🦸", "Superman back raises", "Lie face down and lift arms and legs together. Hold 3 seconds. Do 3 sets of 12."),
    Day(19, "🏃", "High knees", "Run in place, driving knees toward hip height. Do 6 rounds of 30 seconds, resting 30 seconds between."),
    Day(20, "📐", "Side planks", "Hold a side plank for 20–30 seconds each side, 3 rounds. Stack your feet and lift your hips high."),
    Day(21, "🛁", "Recovery & foam rolling", "Use a foam roller or rolled towel on calves, quads and back for 15 minutes. Roll slowly over tight spots."),
    Day(22, "🚲", "30-minute cardio of choice", "Cycle, swim, jog or dance for 30 minutes at a steady, conversational pace. Pick what you enjoy."),
    Day(23, "🦘", "Jump squats", "Squat down, then jump and land softly. Do 4 sets of 10 with a minute of rest."),
    Day(24, "🔺", "Pike push-ups", "Keep your hips high in an inverted V, bend your elbows and lower your head toward the floor. Do 3 sets of 6–10."),
    Day(25, "🥊", "Shadow boxing", "Throw jabs, crosses and hooks for 3-minute rounds with a minute rest. Stay light on your feet. Do 4 rounds."),
    Day(26, "⚖️", "Single-leg balance", "Stand on one leg for 45 seconds, then switch. Close your eyes to make it harder. Do 3 rounds per leg."),
    Day(27, "🎒", "Backpack rows", "Fill a backpack with books. Hinge forward and row it to your ribs. Do 3 sets of 12 each arm."),
    Day(28, "⏱️", "Tabata circuit", "Pick 4 moves you like. Work 20 seconds, rest 10 seconds, for 8 rounds. That's 16 minutes."),
    Day(29, "🌄", "Long walk or jog", "Go for 45 minutes at an easy pace outdoors. Enjoy the scenery and notice how much stronger you feel."),
    Day(30, "🏆", "Victory circuit!", "Do a full circuit of squats, push-ups, plank, lunges and burpees. Repeat your day-15 test and compare. You did it!")
)
