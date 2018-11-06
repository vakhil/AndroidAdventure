# Recycler View 

Recycler View is a new ViewGroup that is prepared to render any adaptor-based view in a similar way. Use the RecyclerView widget when you have data collections whose elements change at runtime based on user action or network events.

[Here](https://guides.codepath.com/android/using-the-recyclerview#binding-the-adapter-to-the-recyclerview) is an excellent resource for learning the basics of Recycler View.

[Simplified Coding](https://www.youtube.com/watch?v=USbTcGx1mD0&list=PLk7v1Z2rk4hjHrGKo9GqOtLs1e2bglHHA) also has some great resources for learning this concept in depth.

##Using the Recycler View

### i) Add Recycler View Support to gradle build file

Just go to app/build.gradle and in dependencies, add implementation 'com.android.support:recyclerview-v7:27.1.1'

### ii) Define a model class to use as the data source

We need to create a class which has information about what type of list we are creating. Suppose, we are creating a list of items where each item has a heading and description. The class can be like

``` Class ListItem{
  private String heading;
  private String description;
}  
```

So, like above we create a class alongside MainActivity.java called ListItem.java with the above contents.

### iii) Add a recycler View within activity_main.xml to add a Recycler View

```
<LinearLayout >
    <RecyclerView id='recycler'/>
</LinearLayout>
```

### iv) Create a custom layout XML for viewing each item in the RecyclerView would look like. 

This file should be alongside activity_main.xml. In our case, we name it as list_item.xml

```
<LinearLayout>
  <CardView>
    <LinearLayout>
      <TextView id ="head">
      <TextView id="desc">
    </LinearLayout>
  </CardView>
</LinearLayout>
```

### v) Create a RecyclerView.Adapter and ViewHolder


```
class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>
{
  private List<ListItem> listItems;
  public MyAdapter(List<ListItem> listItems) 
  {
        this.listItems = listItems; 
  }
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item,viewGroup,false);
        return new ViewHolder(v);
  }

  public class ViewHolder extends RecyclerView.ViewHolder
  {
        public TextView head;
        public TextView description;
         public ViewHolder(@NonNull View itemView) {
            super(itemView);
            head = (TextView) itemView.findViewById(R.id.textViewHead);
            description = (TextView) itemView.findViewById(R.id.textViewDesc);
        }
  }
  public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Log.d(TAG, "OnBindViewHolder called");
        ListItem listItem = listItems.get(i);
        viewHolder.head.setText(listItem.getHead());
        viewHolder.description.setText(listItem.getDescription());
  }
}
```
This is where the magic happens and where the concept is a bit tough to understand. Adapter receives an ArrayList<ListItems>. This list has all the items which are to be displayed by the RecyCyler View. This List will be passed on from MainActivity.java. 

Adapter stores the arrayList and inflates the induvidual item XML i.e list_item.xml which we create. This is done in onCreateViewHolder() method. In the method onBindViewHolder(), we actually bind our data pased in the ArrayList to the XML and hence actually create the list. 

Adapter basically binds the data to XML UI Layout. 

### vi) Bind the Adapter to the RecylerView

This is the last Step and now we need to bind our Adapter to our reCycler View.
In MainActivity.java, in the onCreate function, we need to do this.

```
ArrayList<ListItem> list;
onCreate(){
RecyclerView x = (RecyclerView) findViewById(R.id.recycler);
list = Generate(20); //Generate 20 Headings and Description which you want in your list
MyAdapter adapter = new MyAdapter(list);
x.setAdapter(adapter);
x.setLayoutManager(new LinearLayoutManager);
}
```
So, whole process in simple teerms is first bind UI(list_item.xml) to data passed using Adapter. Then, bind Adapter to RecyclerView in onCreate Function.
