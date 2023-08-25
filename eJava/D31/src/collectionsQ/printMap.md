## map.entrySet()

>> public Set<Map.Entry<K,​V>> entrySet()

```
Map<T,U> map = new HashMap<>();

for (Entry<T,U> entrySet : map.entrySet()){
	syso(entrySet.getKey());
	syso(entrySet.getValue());
}
```

## map.keySet(), map.get()

>> public Set<K> keySet()
>> public V get​(Object key)

```
Set<T> keys = map.keySet();
for(T key : keys)
	syso(key + " " + map.get(key))	// key + value
```

## map.values() 

>> public Collection<V> values()

```
Collection<T> values = map.values();
syso(values)	// 전체 value들 출력
```

## Iterator

```
Iterator<Entry<T,U>> iter = map.entrySet().iterator();
while(iter.hasNext()){
	Entry<T,U> entrySet = (Entry<T,U>)iter.next();
	syso(entrySet.getKey() + " " + entrySet.getValue());
}
```

## forEach

```
map.forEach((key,value) -> {
	syso(key + " " + value);
});
```