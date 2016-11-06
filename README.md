# Inspiration
Lonliness in elderly people leads to depression and health issues.
We did some research and found that seniors who were lonely are more likely to decline and die faster.

18% of seniors live alone.
43% of seniors report feeling lonely on a regular basis.

# What it does
The app allows local young volunteers to meet & interact with seniors.
The app helps match the interests of young people and elderly people & proximity to maximize common ground between generations.
This app helps solve the problem of elderly loneliness by connecting young people with older generation which their mental health.

# How we built it
Android Java that interacts with AWS API to access an S3 database.

# Challenges we ran into
Collectively, we accidentally posted the secret key to our AWS service to github three different times, which triggered 
a few automatic warning emails from various sources and had us scrambling to rotate new keys and check that there were no unauthorized services created. 

Only one of our team members had Android studio installed beforehand. The rest of us couldn't download it in a timely manner (6+hr download), 
so to contribute any Java code, we wrote modules independent of Android's sdk and built them with maven.

# Accomplishments that we're proud of
+ **It runs**. It pulls data from the cloud and lists it on the app.
+  **Debug**. There were some interesting crashes that we overacame: NetworkOnMainThreadException,
"Cannot find the path file for Java.lang.Object", NullPointerException, etc.
+ **Teamwork**. We stayed together as a team and kept positive for all 25 hours of the hackathon.

# What we learned
We got together for three minutes and threw out some blurbs of what we learned and here's some quotes that came out.
+ "How to write XML files"
+ "And Introduction to Java"
+ "How to protect AWS credentials"
+ "What a backend does"
+ "AWS in Android Development"

# What's next for Generation2U
We had a few features that didn't quite make the timeframe for this hackathon that we thought might be nice to implement.
###Voice to text for seniors
More often than not, seniors are not tech savvy. 
We envisioned a voice to text server that would enable seniors to create a profile completely through a voice call rather than a smartphone app.
Their profile would be tied to their phone number, which would allow seniors to make future calls to our service to update their profile.
###mechanism to contact seniors
In the same vein of our envisioned voice tree, we need a system to contact seniors of interested young volunteers. We would prefer to make contact
through a phone call instead of an in-app message. 
###Cloud housekeeping
If this project is to go large scale, it would need some modifications to how data is stored in the cloud, and it would need a system to add new users. 